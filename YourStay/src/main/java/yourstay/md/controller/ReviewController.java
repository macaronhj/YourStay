package yourstay.md.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import yourstay.md.domain.reviewVO;
import yourstay.md.service.FileService;

@Log4j
@AllArgsConstructor
@Controller
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	FileService service;
	
//	@GetMapping(value="/registerReview")
//    public ModelAndView gohome(HttpSession session){
//        log.info("MypageController -> gohome 요청");
//        int vo = mapper.insertReview((reviewVO)session.getAttribute("memail"));
//        ModelAndView mv = new ModelAndView("mypage/home","member",vo);
//        return mv;
//    }
	
	@PostMapping(value="/registerReview")
    public ModelAndView addreview(reviewVO reviewVo, MultipartHttpServletRequest mpRequest)throws Exception {
       //작은미션: (멀티파트업로드) 구현! 
      log.info("MypageController -> addreview 요청");
      log.info("MypageController -> addreview reviewVo: "+ reviewVo.getReview());
      service.write(reviewVo, mpRequest);
      ModelAndView mv = new ModelAndView();
      mv.setViewName("redirect:/mypage/home");
       return mv;
    }
//		@GetMapping(value="/review")
//	    public ModelAndView review(HttpSession session){
//	        log.info("MypageController -> review 요청");
//	        reviewVO vo = reviewMapper.getUser((String)session.getAttribute("memail"));
//	        ModelAndView mv = new ModelAndView("mypage/review","member",vo);
//	        log.info("####vo:"+vo);
//	        return mv;
//	    }
}
