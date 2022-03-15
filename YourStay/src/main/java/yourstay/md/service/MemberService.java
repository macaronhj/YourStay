package yourstay.md.service;

import yourstay.md.domain.MemberVO;

public interface MemberService {
	public MemberVO login(MemberVO vo) throws Exception;
}
