package yourstay.md.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import yourstay.md.domain.MemberVO;
import yourstay.md.domain.reservationVO;
import yourstay.md.domain.reviewVO;
import yourstay.md.mapper.MemberMapper;
import yourstay.md.mapper.ReviewMapper;
import yourstay.md.service.RoomHistoryService;

@Log4j
@AllArgsConstructor
@Controller
@RequestMapping("/mypage")
public class MypageController {
	@Autowired
	MemberMapper memberMapper;
	
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
	@GetMapping(value="/wishlist")
    public ModelAndView wishlist(ModelAndView mv){
        log.info("MypageController -> wishlist 요청");
        mv.setViewName("mypage/wishlist");
        return mv;
    }
	@GetMapping(value="/roomHistory")
    public ModelAndView roomHistory(long mseq){
        log.info("MypageController -> roomHistory 요청");
        List<reservationVO> vo = roomService.getRoomList(mseq);
        ModelAndView mv = new ModelAndView("mypage/roomHistory","vo",vo);
        log.info("####vo:"+vo.toString());
       
        
        return mv;
    }
	@GetMapping(value="/review")
    public ModelAndView review(HttpSession session){
        log.info("MypageController -> review 요청");
        reviewVO vo = reviewMapper.getUser((String)session.getAttribute("memail"));
        ModelAndView mv = new ModelAndView("mypage/review","member",vo);
        log.info("####vo:"+vo);
        
        return mv;
    }
//	@PostMapping(value="/wishlist")
//    public ModelAndView wishlist(HttpSession session){
//        log.info("MypageController -> wishlist 요청");
//        MemberVO vo = memberMapper.getUser((String)session.getAttribute("memail"));
//        ModelAndView mv = new ModelAndView("mypage/review","member",vo);
//        return mv;
//    }
}
