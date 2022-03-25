package yourstay.md.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import yourstay.md.domain.Accommodation;
import yourstay.md.domain.Accomoption;
import yourstay.md.domain.Image;
import yourstay.md.domain.MemberVO;
import yourstay.md.domain.Reservation;
import yourstay.md.domain.reviewVO;
import yourstay.md.mapper.MemberMapper;
import yourstay.md.mapper.ReviewMapper;
import yourstay.md.service.AccommodationService;
import yourstay.md.service.MemberService;
import yourstay.md.service.MyPageService;
import yourstay.md.service.RoomHistoryService;

@Log4j
@AllArgsConstructor
@Controller
@RequestMapping("/mypage")
public class MypageController {
	@Autowired
	private AccommodationService accommodationService;
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private MyPageService myPageService;
	@Autowired
	ReviewMapper reviewMapper;
	@Autowired
	RoomHistoryService roomService;
	
	
	@GetMapping(value="/home")
    public ModelAndView gohome(HttpSession session){
        log.info("MypageController -> gohome 요청");
        MemberVO vo = memberMapper.getUser((String)session.getAttribute("memail"));
        ModelAndView mv = new ModelAndView("mypage/home","member",vo);
        return mv;
    }
	@PostMapping("/register.do")
	public String roomRegister(ModelAndView mv, Accomoption aco, Accommodation ac, Image img, String memail) {
		log.info("roomOption Data -> info 전달");
		log.info("로그인한 회원의 메일: " + memail);
		MemberVO member = memberMapper.getUser(memail);
		log.info("로그인한 회원의  메일: " + member.getMemail()+", 회원의 번호: "+ member.getMseq() +", 회원의 이름: "+member.getMname());
//		MemberVO member = accommodationService.getRegisterMemberSeqS(mseq);
//		accommodationService.insertImageS(img);// 이미지 테이블에 insert
//		ac.setMseq(member.getMseq());//insert할 회원번호 설정(숙소등록하는 회원번호)
//		accommodationService.insertAccommodationS(ac);// 숙소  테이블에 insert
//		accommodationService.insertAccomoptionS(aco); // 숙소옵션 테이블에 insert
//		log.info("옵션번호: "+ aco.getAid() +", 숙소번호 : "+aco.getOid()+", 방개수 : "+aco.getRnum()+", TV유무 : "+ aco.getTv());
		//여기에  info페이지로 값을 전달 
		return "redirect:home";
	}
	
	@GetMapping(value="/wishlist/{mseq}")
    public String wishlist(@PathVariable("mseq") long mseq, Model model){
        log.info("MypageController -> wishlist 요청");
        Map<String, List> wishMap = myPageService.getWishS(mseq);
    	
		model.addAttribute("wishMap", wishMap);
		
		return "mypage/wishlist";
    }
	@GetMapping(value="/roomHistory")
    public ModelAndView roomHistory(long mseq){
        log.info("MypageController -> roomHistory 요청");
        List<Reservation> vo = roomService.getRoomList(mseq);
        ModelAndView mv = new ModelAndView("mypage/roomHistory","vo",vo);
        log.info("####vo:"+vo.toString());
       
        
        return mv;
    }
	@GetMapping(value="/roomReservation")
    public ModelAndView roomReservation(long mseq){
        log.info("MypageController -> roomReservation 요청");
        List<Reservation> vo = roomService.getRoomList(mseq);
        ModelAndView mv = new ModelAndView("mypage/roomReservation","vo",vo);
        log.info("####vo:"+vo.toString());
       
        
        return mv;
    }
   @GetMapping(value="/review")
    public ModelAndView review(HttpSession session, @RequestParam long aid, @RequestParam long mseq) {
        log.info("aid : " + aid+ "// mseq:" + mseq);
        List<reviewVO> vo = reviewMapper.getUser((String) session.getAttribute("memail"));
        log.info("####vo:"+vo);
        reviewVO reviewvo = vo.get(0);
        reviewvo.setAid(aid); //유저가 선택한 숙소번호 입력
        ModelAndView mv = new ModelAndView("mypage/review","member",reviewvo);
        
        return mv;
    }
}
