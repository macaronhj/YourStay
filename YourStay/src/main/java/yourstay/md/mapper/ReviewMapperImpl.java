package yourstay.md.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import yourstay.md.domain.reviewVO;

public class ReviewMapperImpl implements ReviewMapper {
	
	@Autowired
	SqlSession session;
	
	@Override
	public void insertFile(Map<String, Object> map) throws Exception {
		session.insert("yourstay.md.mapper.ReviewMapper.insertFile", map);

	}

	@Override
	public void insert(reviewVO reviewVo) {
		session.insert("yourstay.md.mapper.ReviewMapper.insert",reviewVo);
		
	}

	@Override
	public reviewVO getUser(String memail) {
		return session.selectOne("yourstay.md.mapper.ReviewMapper.getUser", memail);
	}

}
