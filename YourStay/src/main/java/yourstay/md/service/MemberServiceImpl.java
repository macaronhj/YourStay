package yourstay.md.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import yourstay.md.domain.MemberVO;
import yourstay.md.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject MemberMapper memberMapper;
	
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		return memberMapper.login(vo);
	}

}
