package yourstay.md.mapper;

import java.util.List;

import yourstay.md.domain.Reservation;
import yourstay.md.domain.ReservationDateVO;

public interface ReservationMapper {
	/*
	 * 예약테이블 등록
	 */
	public void insertReservation(Reservation reservationVO);
	/*
	 * 예약날짜테이블 등록
	 */
	public void insertReservationDate(ReservationDateVO rdateVO);
	/*
	 * 예약날짜테이블 조회
	 */
	public List<ReservationDateVO> selectReservationDate(Reservation reservationVO);
	
	public List<ReservationDateVO> selectAidReservationDate(long aid);
	/*
     * 호스트용 알림기능 checkView 찾기 
    */
   public Long checkView(long mseq);
   /*
     * 게스트용 알림기능 checkView 찾기
    */
   public Long checkView2(long mseq);
   
   /*
     * rid로 Reservation 찾기 
    */
    public int findReservationRid(long rid);
    /*
     * mseq로 Reservation 찾기 
    */
    public List<Reservation> findReservationMseq(long mseq);
    /*
     * 호스트 알림 업데이트 하기 ( Reservation UpdateRaccept )  
    */
    public int hostUpdate(long rid);
    /*
     * 게스트 알림 업데이트 하기 ( Reservation UpdateRaccept )  
    */
    public int guestUpdate(Reservation reservation);
}