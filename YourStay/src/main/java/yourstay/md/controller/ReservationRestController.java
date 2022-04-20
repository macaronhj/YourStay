package yourstay.md.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;
import yourstay.md.domain.Image;
import yourstay.md.domain.Reservation;
import yourstay.md.domain.resultVO;
import yourstay.md.mapper.SearchMapper;
import yourstay.md.service.AccommodationService;
import yourstay.md.service.ReservationService;

@Controller
@RequestMapping("/res")
@Log4j
public class ReservationRestController {
	@Autowired
	SearchMapper searchMapper;
	@Autowired
	AccommodationService accommodationService;
	@Autowired
	ReservationService reservservice;

	@PostMapping("/reservation.do")
	public String checkReservation(Reservation reservationVO) {
		log.info("ReservationController // checkReservation reservationVO :" + reservationVO);
		reservservice.ReservationDateS(reservationVO);
		return "redirect:/";
	}
	/*
	 * 숙소상세내역 페이지 이동
	 */
	
	@PostMapping("/reservdetail")
	public ModelAndView reserdetailPage(@RequestParam Integer aid, @RequestParam String rstart, @RequestParam String rend, @RequestParam long resultprice, @RequestParam long days) {
		log.info("reserdetailPage : " + aid);
		log.info("ReservationCon reserdetailPage //// Integer aid : "  + aid+ ", startDate : "+ rstart+", endDate : "+ rend);
		List<Image> roomImage = accommodationService.selectRoomImageS(aid); //숙소이미지
		String ipath1 = roomImage.get(0).getStored_file_name(); 
		List<resultVO> rlist = searchMapper.getAccommodationByAccommodationId(aid);
		resultVO rVO = rlist.get(0);
		rVO.setIpath1(ipath1);
		rVO.setRstart(rstart);//사용자선택 시작날짜 적용
		rVO.setRend(rend);//사용자선택 끝날짜 적용
		rVO.setDays(days);//숙박일수 적용
		rVO.setResultprice(resultprice); //최종 금액 적용
		rVO.setAid(aid);
		
		
		log.info("reserdetailPage resultVO: " + rVO.toString());
		return new ModelAndView("/reserdetail/reservation","rdetail",rVO);
	}
	/*
     * 호스트 업데이트 하기 ! 
    */
    @PostMapping("/hostUpdate")
    public ModelAndView hostUpdate(ModelAndView mv, long rid) {
    	log.info("##ReservationRestController hostUpdate 접속!!!! ");
       reservservice.hostUpdateS(rid);
       mv.addObject("rid", rid);
       log.info("##ReservationRestController updateRaccept 완료!!!! ");
       mv.setViewName("redirect: /mypage/accessPage");
       return mv;
    }
    /*
     * 게스트 업데이트 하기 ! 
    */
    @PostMapping("/guestUpdate")
    public ModelAndView guestUpdate(ModelAndView mv, Reservation reservation) {
       log.info("reservation : "+ reservation);
       reservservice.guestUpdateS(reservation);
       mv.addObject("rid", reservation.getRid());
       log.info("##ReservationRestController guestUpdate 완료!!!! ");
       mv.setViewName("redirect: /mypage/accessPage");
       return mv;
    }
    @GetMapping("/findReservation")
    public ModelAndView findReservationRaccept(ModelAndView mv, long rid) {
       log.info("@@ ReservationControler findReservationRaccept");
       mv = new ModelAndView("/mypage/goReservationRoom", "FindReservation", reservservice.findReservationRidS(rid));
       return mv;
    }
}