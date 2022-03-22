package yourstay.md.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yourstay.md.domain.MemberVO;
import yourstay.md.mapper.MemberMapper;
import static yourstay.md.domain.LoginConst.*;

@Service
public class LoginService {
	@Autowired
	MemberMapper mapper;
	private static final LoginService instance = new LoginService();
	public static LoginService getInstance() {
		return instance;
	}
	
	public MemberVO getMemberS(String memail) {
		MemberVO m = mapper.getUser(memail);
		m.setMpwd("");
		
		return m;
	}
	
    public int check(String memail, String mpwd) {
    	MemberVO m = mapper.getUser(memail);
    	if(m == null) {
    		return NO_ID;//그런 email을 가진 회원이 없음
    	}else {
    		String dbPwd = m.getMpwd();
    		if(dbPwd != null) dbPwd = dbPwd.trim();
    		
    		if(!dbPwd.equals(mpwd)) {
    			return NO_PWD; //email은 존재하지만 비번이 다른 경우 
    		}else {
    			return YES_ID_PWD; //email과 pwd가 맞음 
    		}
    				
    	}
    }
}
