package yourstay.md.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;

import yourstay.md.domain.MemberVO;
@Primary
@Repository
public class MemberMapperImpl implements MemberMapper {
	@Autowired
	SqlSession session;
	
	@Override
	public MemberVO getUser(String memail) {
		return session.selectOne("yourstay.md.mapper.MemberMapper.getUser", memail);
	}

	@Override
	public List<MemberVO> getUserList() {
		return session.selectList("yourstay.md.mapper.MemberMapper.getUsers");
	}

	@Override
	public int addUser(MemberVO user) {
		return session.insert("yourstay.md.mapper.MemberMapper.insertUser", user);
	}

	@Override
	public int removeUser(String memail) {
		return session.delete("yourstay.md.mapper.MemberMapper.deleteUser", memail);
	}

	@Override
	public boolean login(String memail, String mpwd) {
		Map<String, String> parameters = new HashMap<>();
		parameters.put("memail", memail);
		parameters.put("mpwd", mpwd);
		
		MemberVO result = session.selectOne("yourstay.md.mapper.MemberMapper.loginUser", parameters);
		
		if(result != null)
			return true;
		else
			return false;
	}

}
