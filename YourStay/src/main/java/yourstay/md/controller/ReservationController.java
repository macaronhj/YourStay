package yourstay.md.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;
import yourstay.md.dao.interfaces.ReservationDAO;
import yourstay.md.domain.Reservation;
import yourstay.md.domain.resultVO;
import yourstay.md.mapper.SearchMapper;

@Controller
@RequestMapping("/res")
@Log4j
public class ReservationController {
	@Autowired
	ReservationDAO reservationDAO;
	@Autowired
	SearchMapper searchMapper;
	/*
	 * 숙소상세페이지에서 사용자 선택값을들 넘겨받아야함
	 */
	@RequestMapping("/reservation.do")
	public ModelAndView reservation(Reservation reserv) {
		List<String> result = reservationDAO.addReservation(reserv); //result 리스트의 0번째 값이 true이면 예약가능 false이면 예약 불가능
		if(result.get(0)=="TRUE") {
			//예약가능
		}else {
			//예약불가
		}
		return null;
	}
	/*
	 * 숙소상세내역 페이지 이동
	 */
	@PostMapping("/reservdetail")
	public ModelAndView reserdetailPage(@RequestParam Integer aid, @RequestParam String rstart, @RequestParam String rend, @RequestParam long resultprice, @RequestParam long days) {
		log.info("reserdetailPage : " + aid);
		log.info("ReservationCon reserdetailPage //// Integer aid : "  + aid+ ", startDate : "+ rstart+", endDate : "+ rend);
	      
		List<resultVO> rlist = searchMapper.getAccommodationByAccommodationId(aid);
		resultVO rVO = rlist.get(0);
		rVO.setRstart(rstart);//사용자선택 시작날짜 적용
		rVO.setRend(rend);//사용자선택 끝날짜 적용
		rVO.setDays(days);//숙박일수 적용
		rVO.setResultprice(resultprice); //최종 금액 적용
		rVO.setAid(aid);
		
		
		log.info("reserdetailPage resultVO: " + rVO.toString());
		return new ModelAndView("/reserdetail/reservation","rdetail",rVO);
	}
}
