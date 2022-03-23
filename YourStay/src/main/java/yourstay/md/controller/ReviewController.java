package yourstay.md.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import yourstay.md.domain.reviewVO;
import yourstay.md.mapper.ReviewMapper;

@Log4j
@AllArgsConstructor
@Controller
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	ReviewMapper mapper;
	@GetMapping(value="/registerReview")
    public ModelAndView gohome(HttpSession session){
        log.info("MypageController -> gohome 요청");
        reviewVO vo = mapper.insertReview((reviewVO)session.getAttribute("memail"));
        ModelAndView mv = new ModelAndView("mypage/home","member",vo);
        return mv;
    }
}
