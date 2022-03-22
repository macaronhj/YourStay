package yourstay.md.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import yourstay.md.domain.MemberVO;
import yourstay.md.mapper.MemberMapper;

@Log4j
@AllArgsConstructor
@Controller
@RequestMapping("/mypage")
public class MypageController {
	@Autowired
	MemberMapper memberMapper;
	
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
	@GetMapping(value="/review")
    public ModelAndView checkBook(ModelAndView mv){
        log.info("MypageController -> checkBook 요청");
        mv.setViewName("mypage/review");
        return mv;
    }
}
