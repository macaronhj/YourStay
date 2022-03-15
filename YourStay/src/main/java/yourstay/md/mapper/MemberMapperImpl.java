package yourstay.md.mapper;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import yourstay.md.domain.MemberVO;

@Repository
public class MemberMapperImpl implements MemberMapper {
	@Inject SqlSession sql;
	
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		
		return sql.selectOne("memberMapper.login", vo);
	}
}
