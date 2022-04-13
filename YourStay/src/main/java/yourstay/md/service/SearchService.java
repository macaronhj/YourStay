package yourstay.md.service;

import java.util.List;

import yourstay.md.domain.Accommodation;
import yourstay.md.domain.resultVO;
import yourstay.md.domain.reviewVO;

public interface SearchService {
	public List<resultVO> getAccommodationByAccommodationId(long aid);
	public List<Accommodation> getAccommodationListBySearchBar(String aloc, String startdate, String deadline, int apeople);
	public List<reviewVO> getReviewByAccommodationId(long aid);

}
