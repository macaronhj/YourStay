package yourstay.md.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import yourstay.md.domain.Reservation;
import yourstay.md.domain.ReservationDateVO;
import yourstay.md.mapper.ReservationMapper;
import yourstay.md.util.DateMaker;
@Service
@Slf4j
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	ReservationMapper reservationMapper;
	/*
	 * 예약테이블 등록
	 */
	@Override
	public void insertReservationS(Reservation reservationVO) {
		reservationMapper.insertReservation(reservationVO);
	}
	/*
	 * 예약날짜테이블 등록
	 */
	@Override
	public void insertReservationDateS(ReservationDateVO rdateVO) {
		reservationMapper.insertReservationDate(rdateVO);
	}
	/*
	 * 예약날짜테이블 조회
	 */
	@Override
	public List<ReservationDateVO> selectReservationDateS(Reservation reservationVO) {
		reservationMapper.selectReservationDate(reservationVO);
		return null;
	}
	@Override
	public void ReservationDateS(Reservation reservationVO) {
		ArrayList<String> selectDateList = (ArrayList<String>) DateMaker.getDateList(reservationVO.getRstart(), reservationVO.getRend());
		ArrayList<ReservationDateVO> checkList = (ArrayList<ReservationDateVO>) reservationMapper.selectReservationDate(reservationVO);
		ReservationDateVO rdateVO = new ReservationDateVO();
		if(checkList.size() != 0) { //사용자 입력 값이 예약테이블에 없으면
			log.error("예약불가합니다");
		}else {
			//예약가능1
			log.error("예약가능합니다");
			reservationMapper.insertReservation(reservationVO);
			rdateVO.setAid(reservationVO.getAid());
			rdateVO.setRid(reservationVO.getRid());
			for(int i = 0; i<selectDateList.size(); i++) {
				rdateVO.setRdate(selectDateList.get(i));
				reservationMapper.insertReservationDate(rdateVO);
			}
		}
	}

	@Override
	   public List<ReservationDateVO> selectAidReservationDateS(long aid) {
	      return reservationMapper.selectAidReservationDate(aid);
	   }
	/*
     * 호스트 알람 찾기 
    */
   @Override
   public Long checkView(long mseq) {
      return reservationMapper.checkView(mseq);
   }
   /*
     * 게스트 알람 찾기 
    */
   @Override
   public Long checkView2(long mseq) {
      return reservationMapper.checkView2(mseq);
   }
   /*
     * rid로 Reservation 찾기 
     */
   @Override
   public int findReservationRidS(long rid) {
      log.error("ReservationServiceImpl findRacceptS 접속");
      log.error("rid: "+ rid);
      return reservationMapper.findReservationRid(rid);
   }
   /*
     * mseq로 Reservation 찾기 
     */
   @Override
   public List<Reservation> findReservationMseqS(long mseq) {
      log.info("ReservationServiceImpl findRacceptS 접속");
      return reservationMapper.findReservationMseq(mseq);
   }
   /*
    *해당 예약건 수락해주는 기능 ( Reservation UpdateRaccept )  
    */
   @Override
   public int hostUpdateS(long rid) {
      log.info("ReservationServiceImpl racceptUpdateS 접속");
      int result = reservationMapper.hostUpdate(rid);
      if(result>0) {
         log.info("ReservationServiceImpl racceptUpdateS 성공!!");
      }else {
         log.info("ReservationServiceImpl racceptUpdateS 실패!!!!");
      }
      return result;
   }
   /*
    *해당 예약건 수락해주는 기능 ( Reservation UpdateRaccept )  
    */
   @Override
   public int guestUpdateS(Reservation reservation) {
      log.info("ReservationServiceImpl racceptUpdateS 접속");
      int result = reservationMapper.guestUpdate(reservation);
      if(result>0) {
         log.info("ReservationServiceImpl racceptUpdateS 성공!!");
      }else {
         log.info("ReservationServiceImpl racceptUpdateS 실패!!!!");
      }
      return result;
   }
}