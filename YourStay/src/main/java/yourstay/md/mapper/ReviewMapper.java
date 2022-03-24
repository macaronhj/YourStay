package yourstay.md.mapper;

import java.util.Map;

import yourstay.md.domain.reviewVO;

public interface ReviewMapper {
	
	public reviewVO getUser(String memail);
	
	public void insertFile(Map<String, Object> map) throws Exception;

	public void insert(reviewVO reviewVo);
}
