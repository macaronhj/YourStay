package yourstay.md.service;

import java.util.List;

import yourstay.md.domain.reservationVO;

public interface RoomHistoryService {
	public List<reservationVO> getRoomList(String memail);
}
