package yourstay.md.dao.interfaces;

import java.util.List;

import yourstay.md.domain.Accommodation;

public interface AccommodationDAO {
	public List<Accommodation> getAccommodationListBySearchBar(String aloc, String startDate, String endDate, int apeople);
}
