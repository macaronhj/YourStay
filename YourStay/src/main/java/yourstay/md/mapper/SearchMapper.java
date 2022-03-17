package yourstay.md.mapper;

import java.util.List;

import yourstay.md.domain.Accommodation;

public interface SearchMapper {
//	// CRUDs
//		public int addAccommodation(AccommodationVO accom);
//		public int removeAccommodation(int accommodationId);
//		public int updateAccommodation(AccommodationVO accom);
//		public AccommodationVO getAccommodationByAccommodationId(int accommodationId);
//		// public List<AccommodationVO> getAccommodationListByLocation(String location);
//		
//		// Functional Methods
//		public float getAveragePoint();
		public List<Accommodation> getAccommodationListBySearchBar(String aloc, String startdate, String deadline, int apeople);
//
//		public List<AccommodationVO> getAccommodationListBySearchBarUsingFilter(String location, String startDate, String endDate,
//				int numberOfPeople, int startPrice, int endPrice);
//		public List<AccommodationVO> getAccommodationListBySearchBarUsingTypeFilter(String location, String startDate,
//				String endDate, int numberOfPeople, int totChecked);
//
//		public List<AccommodationVO> getAccommodationByHostId(String host_id);
//		public int checkLastAccomodationId();
}
