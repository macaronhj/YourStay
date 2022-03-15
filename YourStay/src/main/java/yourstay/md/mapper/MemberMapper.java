package yourstay.md.mapper;

import yourstay.md.domain.MemberVO;

public interface MemberMapper {
	MemberVO login(MemberVO vo) throws Exception;
}
