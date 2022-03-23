package yourstay.md.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import yourstay.md.domain.reviewVO;
@Primary
@Repository
public class ReviewMapperImpl implements ReviewMapper {

	@Autowired
	SqlSession session;
	
	@Override
	public List<reviewVO> getReview(long renum) {
		return session.selectOne("yourstay.md.mapper.ReviewMapper.getReview", renum);
	}

	@Override
	public reviewVO insertReview(reviewVO vo) {
		return session.selectOne("yourstay.md.mapper.ReviewMapper.getReview", vo);
	}

	@Override
	public reviewVO deleteReview() {
		return session.selectOne("yourstay.md.mapper.ReviewMapper.getReview");
	}

}
