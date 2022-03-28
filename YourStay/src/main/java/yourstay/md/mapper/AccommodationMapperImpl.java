package yourstay.md.mapper;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import yourstay.md.domain.Accommodation;
import yourstay.md.domain.MemberVO;

public class AccommodationMapperImpl implements AccommodationMapper {
	
	@Autowired
	SqlSession session;
	
	@Override
	public void insert(Accommodation ac) {
		session.insert("yourstay.md.mapper.AccommodationMapper.insert",ac);

	}

	@Override
	public void insertFile(Map<String, Object> map) throws Exception {
		session.insert("yourstay.md.mapper.AccommodationMapper.insertFile", map);

	}

	@Override
	public MemberVO getRegisterMemberSeq(long mseq) {
		// TODO Auto-generated method stub
		return null;
	}

}
