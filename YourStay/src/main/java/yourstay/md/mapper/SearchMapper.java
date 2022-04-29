package yourstay.md.mapper;

import java.util.List;
import java.util.Map;

import yourstay.md.domain.Accommodation;
import yourstay.md.domain.Reservation;
import yourstay.md.domain.ReservationCheck;
import yourstay.md.domain.resultVO;
import yourstay.md.domain.reviewVO;

public interface SearchMapper {
	public List<resultVO> getAccommodationByAccommodationId(long aid);
	public List<Accommodation> getAccommodationListBySearchBar(Map<String, Object> parameters);
	public List<reviewVO> getReviewByAccommodationId(long aid);
	public List<Accommodation> getAccommodationByLoc();
	public List<Accommodation> getAccommodationListByLocation(String aloc);
	public long getCountGuest(long aid);
	public double getReviewPoint(long aid);
}
