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
		 * ��¿� �޼ҵ� �Դϴ�. (������ �������� �Ұ������� �Ǻ���) >> �ش� �żҵ��� ��ȯ�������� �������� ��)) ���೯¥ ���ý� ��ġ�� ��¥�������� ���༺��! ��ġ�� ��¥�� ������ ���� �Ұ��� �̵�
		 * @param Reservation Reservation ���̺� �߰��� ���������� ��� VO
		 * @return ���� [TRUE, Insert�� ROW����], ���೯¥�� ��ġ�� [FALSE, ��ģ��¥�� String...]
		 */
		List<String> resultList = new ArrayList<>();
		
		String sDate = reserv.getRstart();
		String eDate = reserv.getRend();

		// �������� ����~���ϱ����� ��¥����Ʈ�� ����
		List<String> dateList = DateMaker.getDateList(sDate, eDate);

		// ��¥����Ʈ�� �ߺ� �Ǵ��� Ȯ��
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("accom_id", reserv.getAid());
		parameters.put("startDate", sDate);
		parameters.put("endDate", eDate);
		List<ReservationDate> rdList = session.selectList("reservedDateMapper.checkReservedDate", parameters);
		if (!rdList.isEmpty()) // �ߺ��� ��¥�� �Ϸ�� �ִٸ�, ���� �Ұ���
		{
			resultList.add("FALSE");
			for (ReservationDate ReservedDate : rdList) {
				resultList.add(ReservedDate.getRdate());
			}
		} 
		else 
		{
			// Reservation�� Insert
			int insertedNum = session.insert("reservationMapper.insertReservation", reserv);
			resultList.add("TRUE");
			resultList.add(Integer.toBinaryString(insertedNum));
			
			// Insert�� ���� increase �� reserv_id ���� ������
			int currReservId = session.selectOne("reservationMapper.checkReservId");
			
			// ������ ��¥����Ʈ�� ReservedDate�� ���
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
