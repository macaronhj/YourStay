package yourstay.md.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Controller
@RequestMapping("/mypage")
public class MypageController {
	@GetMapping(value="/home")
    public ModelAndView gohome(ModelAndView mv){
        log.info("MypageController -> gohome 요청");
        mv.setViewName("mypage/home");
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
