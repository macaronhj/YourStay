package yourstay.md.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;
import yourstay.md.domain.Accommodation;
import yourstay.md.domain.Image;
import yourstay.md.domain.MemberVO;
import yourstay.md.domain.Reservation;
import yourstay.md.domain.ReservationCheck;
import yourstay.md.domain.ReservationDateVO;
import yourstay.md.domain.resultVO;
import yourstay.md.domain.reviewVO;
import yourstay.md.mapper.SearchMapper;
import yourstay.md.service.AccommodationService;
import yourstay.md.service.PriceService;
import yourstay.md.service.ReservationService;
import yourstay.md.service.SearchService;

@Log4j
@Controller

/**
 * packageName : yourstay.md.controller
 * fileName : RouteController
 * author : kosmo 3得
 * date : Mar 14, 2022
 * description :
 * ===========================================================
 * DATE                  AUTHOR                  NOTE
 * -----------------------------------------------------------
 * Mar 14, 2022          kosmo 3得             置段 持失
 */

public class RouteController {
	@Autowired
	PriceService priceService;

	@Autowired
	SearchService searchService;
	
	@Autowired
	AccommodationService accommodationService;
	
	@Autowired
	ReservationService reservationService;

	@GetMapping(value = "searchInList.do")
	@ResponseBody
	public List<Accommodation> searchList(@RequestParam String aloc, @RequestParam String startdate,
			@RequestParam String deadline, @RequestParam String person) {
		System.out.println(aloc + " " + startdate + " " + deadline + " " + person);
		int p = Integer.parseInt(person);

		List<Accommodation> acvo = searchService.getAccommodationListBySearchBar(aloc, startdate, deadline, p);
		log.info(acvo.size());
		log.info(acvo.toString());
		return acvo;
	}

	@GetMapping(value = "searchInListFromMainGet.do")
	public ModelAndView searchGetFromMain(@RequestParam String aloc, @RequestParam String startdate,
			@RequestParam String deadline, @RequestParam String person, ModelAndView mv) {
		log.info(aloc + " " + startdate + " " + deadline + " " + person);
		int p = Integer.parseInt(person);
		List<Accommodation> acvo = searchService.getAccommodationListBySearchBar(aloc, startdate, deadline, p);
		log.info("List<Accommodation> acvo size : "+ acvo.size());
		for(Accommodation ac:acvo) {//寿社軒什闘 戚耕走	
			List<Image>roomImage = accommodationService.selectRoomImageS(ac.getAid());
			log.info("searchGetFromMain ///acvo.get("+ac+").getAid(): " + ac.getAid());
			log.info("searchGetFromMain ///roomImage: " + roomImage);
			log.info("searchGetFromMain ///roomImage.get(0).getStored_file_name() : " + roomImage.get(0).getStored_file_name());
			ac.setIpath1(roomImage.get(0).getStored_file_name());
		}
		if(acvo.size()==0) {
			mv.setViewName("nullPage");
		}else {
			log.info(acvo.toString());
			mv = new ModelAndView("searchList", "acvo", acvo);
			mv.setViewName("searchList");
			mv.addObject("voSize", acvo.size());
			mv.addObject("city", aloc);
			mv.addObject("startDate", startdate);
			mv.addObject("endDate", deadline);
			mv.addObject("person", p);
			mv.addObject("acvo", acvo);
		}
		return mv;
	}
	@GetMapping(value = "searchByLocation")
	public ModelAndView searchByLocation(String aloc) {
		List<Accommodation> acvo = searchService.getAccommodationListByLocation(aloc);
		log.info("List<Accommodation> acvo size : "+ acvo.size());
		for(Accommodation ac:acvo) {//寿社軒什闘 戚耕走	
			List<Image>roomImage = accommodationService.selectRoomImageS(ac.getAid());
			log.info("searchGetFromMain ///acvo.get("+ac+").getAid(): " + ac.getAid());
			log.info("searchGetFromMain ///roomImage: " + roomImage);
			log.info("searchGetFromMain ///roomImage.get(0).getStored_file_name() : " + roomImage.get(0).getStored_file_name());
			ac.setIpath1(roomImage.get(0).getStored_file_name());
		}	
//		log.info("acvo 3腰属 : "+acvo.get(3).getIpath1());
		log.info(acvo.toString());
		ModelAndView mv = new ModelAndView("searchList", "acvo", acvo);
		mv.setViewName("searchList");
		mv.addObject("acvo", acvo);

		return mv;
	}

	@GetMapping(value = "roomDetailInfo")
	public ModelAndView searchDetail(@RequestParam long aid, @RequestParam String rstart,
			@RequestParam String rend,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		log.info("RouteCon searchDetail ////  aid : " + aid + ", startDate : " + rstart + ", endDate : " + rend);
		List<Image> roomImage = accommodationService.selectRoomImageS(aid); //寿社戚耕走
		String ipath1 = roomImage.get(0).getStored_file_name();
		String ipath2 = roomImage.get(1).getStored_file_name();
		String ipath3 = roomImage.get(2).getStored_file_name();
//	    MemberVO mvo =(MemberVO)session.getAttribute("loginOkUser");
//	    long mseq = mvo.getMseq();
		List<resultVO> reslist = searchService.getAccommodationByAccommodationId(aid);
		List<reviewVO>  reviewlist = searchService.getReviewByAccommodationId(aid);
		List<ReservationDateVO> rdatelist = reservationService.selectAidReservationDateS(aid);
		long reservation = searchService.getCountGuest(aid);
		double reviewpoint = searchService.getReviewPoint(aid);
		log.info("RouteCon searchDetail mseq : "+ aid);
		log.info("RouteCon searchDetail ipath1 : "+ ipath1);
		log.info("RouteCon searchDetail roomImage : "+ roomImage);
		log.info("RouteCon searchDetail reviewlist : "+ reviewlist);
		log.info("RouteCon searchDetail reslist : "+ reslist);
		log.info("RouteCon searchDetail reservation : "+ reservation);
		log.info("RouteCon searchDetail reviewpoint : "+ reviewpoint);
		resultVO resVO = reslist.get(0);
		log.info("RouteCon searchDetail resVO : "+ resVO);
		long diffDays = priceService.daysCalc(rstart, rend);// 寿酵析呪 域至
		long resultprice = priceService.resultPrice(resVO, diffDays);//寿酵析呪拭 魚献 置曽 榎衝 域至
		resVO.setIpath1(ipath1);
		resVO.setIpath2(ipath2);
		resVO.setIpath3(ipath3);
		resVO.setResultprice(resultprice);//置曽榎衝域至 旋遂
		resVO.setRstart(rstart);// 紫遂切識澱 獣拙劾促 旋遂
		resVO.setRend(rend);// 紫遂切識澱 魁劾促 旋遂
		resVO.setDays(diffDays);// 紫遂切識澱 寿酵析呪 旋遂
		resVO.setAid(aid);
		mv.addObject("datelist", rdatelist);
		mv.addObject("reservation",reservation);//号庚切 呪 姥馬奄
		mv.addObject("reviewpoint",reviewpoint);//汝液 軒坂 姥馬奄
		mv.addObject("reslist", reviewlist);//軒坂軒什闘 穿含
		mv.addObject("resVO", resVO);//寿社舛左 穿含
		mv.setViewName("info/info");
		log.info("searchDetail resVO.getAid() : " + resVO.getAid());
		log.info("searchDetail resultVO: " + resVO.toString());

		return mv;
	}
}
