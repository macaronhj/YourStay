package yourstay.md.mapper;

import java.util.List;

import yourstay.md.domain.reservationVO;

public interface RoomHistoryMapper {
	public List<reservationVO> getRoomList(String memail);
}
