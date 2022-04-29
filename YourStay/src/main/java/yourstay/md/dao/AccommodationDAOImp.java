package yourstay.md.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import yourstay.md.dao.interfaces.AccommodationDAO;
import yourstay.md.domain.Accommodation;
@Primary
@Repository
public class AccommodationDAOImp implements AccommodationDAO {

	@Autowired
	SqlSession session;

	@Override
	public List<Accommodation> getAccommodationListBySearchBar(String city, String startDate, String endDate,
			int p) {
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("city", city);
		parameters.put("startDate", startDate);
		parameters.put("endDate", endDate);
		parameters.put("person", p);
		
		return session.selectList("accommodationMapper.getAccommodationListBySearchBar", parameters);
	}
	
}
