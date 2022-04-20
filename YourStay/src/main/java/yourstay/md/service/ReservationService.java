package yourstay.md.service;

import java.util.List;

import yourstay.md.domain.Reservation;
import yourstay.md.domain.ReservationDateVO;

public interface ReservationService {
	/*
	 * 예약테이블 등록
	 */
	public void insertReservationS(Reservation reservationVO);
	/*
	 * 예약날짜테이블 등록
	 */
	public void insertReservationDateS(ReservationDateVO rdateVO);
	/*
	 * 예약날짜테이블 조회
	 */
	public List<ReservationDateVO> selectReservationDateS(Reservation reservationVO);
	
	public void ReservationDateS(Reservation reservationVO);
	public List<ReservationDateVO> selectAidReservationDateS(long aid);
	/*
     * 호스트 알람 찾기 
    */
   public Long checkView(long mseq);
   /*
     * 게스트 알람 찾기 
    */
   public Long checkView2(long mseq);
    /*
     * rid로 Reservation 찾기 
    */
    public int findReservationRidS(long rid);
    /*
     * mseq로 Reservation 찾기 
    */
    public List<Reservation> findReservationMseqS(long mseq);
    /*
     * 해당 예약건 수락해주는 기능 ( Reservation UpdateRaccept )  
    */
    public int hostUpdateS(long rid);
    /*
     * 해당 예약건 수락해주는 기능 ( Reservation UpdateRaccept )  
    */
    public int guestUpdateS(Reservation reservation);
}