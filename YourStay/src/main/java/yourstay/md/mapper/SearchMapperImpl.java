package yourstay.md.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import yourstay.md.domain.Accommodation;

@Primary
@Repository
public class SearchMapperImpl implements SearchMapper {
	
	@Autowired
	SqlSession session;
	
	@Override
	public List<Accommodation> getAccommodationListBySearchBar(String aloc, String startdate, String deadline,
		int apeople) {

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("aloc", aloc);
		parameters.put("startdate", startdate);
		parameters.put("deadline", deadline);
		parameters.put("apeople", apeople);

		return session.selectList("yourstay.md.mapper.SearchMapper.getAccommodationListBySearchBar", parameters);
	}
}
