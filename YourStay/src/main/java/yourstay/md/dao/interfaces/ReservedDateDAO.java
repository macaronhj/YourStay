package yourstay.md.dao.interfaces;

import java.util.List;

import yourstay.md.domain.ReservationDate;

public interface ReservedDateDAO {
//	CRUDs
	public int addReservedDate(ReservationDate reservationDate);
	public int deleteReservedDateByReservedDateId(int rdId);
	public int deleteReservedListByReservIdDates(int reserv_id, String startDate, String endDate);
	
//	Functional Method
	public int addReservedDateList(List<ReservationDate> reservedDateList);
	public List<ReservationDate> getReservedDateListByAccommodationId(int accommodationId);
	public List<ReservationDate> getReservedDateListByDates(String startDate, String endDate);
}
