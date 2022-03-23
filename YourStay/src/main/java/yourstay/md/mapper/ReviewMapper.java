package yourstay.md.mapper;

import java.util.List;

import yourstay.md.domain.reviewVO;

public interface ReviewMapper {
	public List<reviewVO> getReview(long renum);
	public reviewVO insertReview(reviewVO vo);
	public reviewVO deleteReview();
}
