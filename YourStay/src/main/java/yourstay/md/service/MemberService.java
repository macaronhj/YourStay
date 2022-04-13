package yourstay.md.service;

import java.util.List;

import yourstay.md.domain.MemberVO;

public interface MemberService {
	// CRUDs
		public MemberVO getUser(String memail);
		public List<MemberVO> getUserList();
		public void addUser(MemberVO user);
		public void removeUser(String memail);
		
		// Functional Methods
		public int login(String memail, String mpwd);
}
