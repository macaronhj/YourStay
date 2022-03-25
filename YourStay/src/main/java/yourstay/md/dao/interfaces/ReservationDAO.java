package yourstay.md.dao.interfaces;
import java.util.List;

import yourstay.md.domain.Reservation;

public interface ReservationDAO {
//	CRUDs
	public List<String> addReservation(Reservation reserv);
	public Reservation getReservationByReservId(int reserv_Id);
	public List<Reservation>getReservationListByUserId(String user_Id);
	public List<Reservation>getReservationListByHostId(String host_Id);
	public List<Reservation>getReservationListByAcoomId(int accom_Id);
	public int updateReservation(Reservation reserv); // set NotiHost 0, NotiConfirmed 0
	public int deleteReservationByReservationId(int reservationId);
	
//	Functional Method
	public int getNotiHostByReservID(int reserv_id);
	public int confirmNotiHostByReservID(int reserv_id); // 1
	public int getNotiConfirmedByReservID(int reserv_id);
	public int confirmedNotiConfirmedByReservID(int reserv_id); // 1
	public int deniedNotiConfirmedByReservID(int reserv_id); // 2 
}
