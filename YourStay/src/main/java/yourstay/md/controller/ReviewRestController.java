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
import yourstay.md.service.ReviewService;

@Log4j
@AllArgsConstructor
@Controller
@RequestMapping("/review")

/**
 * packageName : yourstay.md.controller
 * fileName : ReviewRestController
 * author : kosmo 3팀
 * date : Mar 14, 2022
 * description :
 * ===========================================================
 * DATE                  AUTHOR                  NOTE
 * -----------------------------------------------------------
 * Mar 14, 2022          kosmo 3팀             최초 생성
 */

public class ReviewRestController {
	@Autowired
	FileService fileService;	
	@Autowired
	ReviewService reviewService;

	/**
     * 찜 목록 추가  ( DTO 로 요청 받는 경우 )
     * @param WishListVO wishlistvo
     * @return String
     */
	@PostMapping(value="/registerReview")
    public ModelAndView addreview(reviewVO reviewVo, MultipartHttpServletRequest mpRequest)throws Exception {
       //작은미션: (멀티파트업로드) 구현! 
      log.info("MypageController -> addreview 요청");
      log.info("MypageController -> addreview reviewVo: "+ reviewVo.getReview());
      fileService.write(reviewVo, mpRequest);
      ModelAndView mv = new ModelAndView();
      mv.setViewName("redirect:/mypage/home");
       return mv;
    }
}
