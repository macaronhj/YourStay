package yourstay.md.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import yourstay.md.dao.interfaces.ReservationDAO;
import yourstay.md.util.DateMaker;
import yourstay.md.domain.Reservation;
import yourstay.md.domain.ReservationDate;

@Repository

public class ReservationDAOImpl implements ReservationDAO {
	
	@Autowired
	SqlSession session;
    
	@Override
	public List<String> addReservation(Reservation reserv) {
		/**
		 * 출력용 메소드 입니다. (예약이 가능한지 불가능한지 판별용) >> 해당 매소드의 반환값에따라 조건을줌 예)) 예약날짜 선택시 겹치는 날짜가없을면 예약성공! 겹치는 날짜가 있을시 예약 불가로 이동
		 * @param Reservation Reservation 테이블에 추가할 예약정보가 담긴 VO
		 * @return 성공 [TRUE, Insert된 ROW갯수], 예약날짜가 겹치면 [FALSE, 겹친날짜의 String...]
		 */
		List<String> resultList = new ArrayList<>();
		
		String sDate = reserv.getRstart();
		String eDate = reserv.getRend();

		// 예약일의 시작~끝일까지의 날짜리스트를 생성
		List<String> dateList = DateMaker.getDateList(sDate, eDate);

		// 날짜리스트가 중복 되는지 확인
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("accom_id", reserv.getAid());
		parameters.put("startDate", sDate);
		parameters.put("endDate", eDate);
		List<ReservationDate> rdList = session.selectList("reservedDateMapper.checkReservedDate", parameters);
		if (!rdList.isEmpty()) // 중복된 날짜가 하루라도 있다면, 예약 불가능
		{
			resultList.add("FALSE");
			for (ReservationDate ReservedDate : rdList) {
				resultList.add(ReservedDate.getRdate());
			}
		} 
		else 
		{
			// Reservation를 Insert
			int insertedNum = session.insert("reservationMapper.insertReservation", reserv);
			resultList.add("TRUE");
			resultList.add(Integer.toBinaryString(insertedNum));
			
			// Insert로 인해 increase 된 reserv_id 값을 가져옴
			int currReservId = session.selectOne("reservationMapper.checkReservId");
			
			// 생성된 날짜리스트를 ReservedDate에 등록
			for (String stringDate : dateList) {
				session.insert("reservedDateMapper.insertReservedDate",
						new ReservationDate(reserv.getAid(), stringDate, currReservId));
			}
		}
		return resultList;
	}

	@Override
	public Reservation getReservationByReservId(int reserv_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> getReservationListByUserId(String user_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> getReservationListByHostId(String host_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> getReservationListByAcoomId(int accom_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateReservation(Reservation reserv) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteReservationByReservationId(int reservationId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNotiHostByReservID(int reserv_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int confirmNotiHostByReservID(int reserv_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNotiConfirmedByReservID(int reserv_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int confirmedNotiConfirmedByReservID(int reserv_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deniedNotiConfirmedByReservID(int reserv_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
