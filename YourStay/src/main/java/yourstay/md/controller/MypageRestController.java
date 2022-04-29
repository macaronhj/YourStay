package yourstay.md.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import yourstay.md.domain.MemberVO;
import yourstay.md.domain.WishListVO;
import yourstay.md.domain.roomRegisterVO;
import yourstay.md.service.AccommodationService;
import yourstay.md.service.MemberService;
import yourstay.md.service.MyPageService;

@Log4j
@AllArgsConstructor
@Controller
@RequestMapping("/mypage")

/**
 * packageName : yourstay.md.controller
 * fileName : MypageRestController
 * author : kosmo 3팀
 * date : Mar 14, 2022
 * description :
 * ===========================================================
 * DATE                  AUTHOR                  NOTE
 * -----------------------------------------------------------
 * Mar 14, 2022          kosmo 3팀             최초 생성
 */

public class MypageRestController {
	@Autowired
	private AccommodationService accommodationService;
	@Autowired
	private MyPageService myPageService;
	@Autowired
	private MemberService memberService;
	
	/**
     * 숙소 등록  ( DTO 로 요청 받는 경우 )
     * @param roomRegisterVO roomregisterVo
     * @return ModelAndView
     */
	@PostMapping(value = "/register.do")
    public ModelAndView roomRegister(ModelAndView mv, roomRegisterVO roomregisterVo,
          MultipartHttpServletRequest mpRequest) throws Exception {
	   log.info("[MypageRestController -> roomRegister 숙소 등록 요청함]");
       log.info("mpRequest : " +  mpRequest);
       accommodationService.insertAccommodationS(roomregisterVo, mpRequest);
       mv.setViewName("redirect:/mypage/home");
       return mv;
    }
	
	/**
     * 숙소 정보 수정  ( DTO 로 요청 받는 경우 )
     * @param roomregisterVo roomregisterVo
     * @return ModelAndView
     */
	@PostMapping(value = "/modifyRoom")
    public ModelAndView modifyRoom(ModelAndView mv, roomRegisterVO roomregisterVo,
      MultipartHttpServletRequest mpRequest) throws Exception {
	  log.info("[MypageRestController -> roomRegister 숙소 수정 요청함]");
      accommodationService.updateAccommodationS(roomregisterVo, mpRequest);
      log.info("roomregisterVo: " + roomregisterVo);
      mv.setViewName("redirect:/mypage/home");
      return mv;
   }
	
	/**
     * 숙소 삭제  ( DTO 로 요청 받는 경우 )
     * @param Board Board
     * @return ModelAndView
     */
    @PostMapping(value = "/delete")
    public ModelAndView requestDelete(ModelAndView mv, Long aid){
    	log.info("[MypageRestController -> requestDelete 숙소 삭제 요청함]");
    	log.info("[MypageRestController -> aid]: "+aid);
        accommodationService.requestDelete(aid);
        mv.setViewName("redirect:/mypage/home");
        return mv;
    }
    
    /**
     * 회원 정보 수정  ( mname, memail, mpwd, mcallnum 로 요청 받는 경우 )
     * @return ModelAndView
     */
    @PostMapping("updateUser.do")
	public ModelAndView updateMember(ModelAndView mv, long mseq, String mname, String memail, String mpwd, int mcallnum) {
    	log.info("[MypageRestController -> updateMember 회원 정보 수정 요청함]");
        MemberVO member = new MemberVO(mseq, mname, memail, mpwd, mcallnum, 0);
		log.info("####memberVO : " + member);
		int updateResult = memberService.updateUser(member);
		if(updateResult>0) {
			log.info("Member Update 성공");
		}else {
			log.info("Member Update 실패");
		}
		mv.setViewName("redirect:/mypage/home");
		return mv;
	}
    
    /**
     * 회원 탈퇴  ( DTO 로 요청 받는 경우 )
     * @param memail
     * @return ModelAndView
     */
    @PostMapping("removeUser.do")
	public ModelAndView removeUser(ModelAndView mv, String memail, HttpSession session) {
    	log.info("[MypageRestController -> removeUser 회원 탈퇴 요청함]");
		int result = memberService.removeUser(memail);
		if(result>0) {
			log.info("## Controller removeUser 성공!!");
			session.invalidate();
		}else {
			log.info("## Controller removeUser 실패!!");
		}
		mv.setViewName("redirect: /");
		return mv;
	}

    /**
     * 찜 목록 추가  ( DTO 로 요청 받는 경우 )
     * @param WishListVO wishlistvo
     * @return String
     */
	@ResponseBody
	@PostMapping(value="/wishlist/addwish")
	public String addWishList(HttpSession session, WishListVO wishlistvo) {
	   log.info("[MypageRestController -> addWishList 찜 목록 추가 요청함]");
       log.info("####wishlistvo : " + wishlistvo);
       boolean findResult = myPageService.findWishListS(wishlistvo);
       if(findResult) {
    	   myPageService.deleteWishListS(wishlistvo);
    	   log.info("## MypageController deleteWishList 삭제 성공");
    	   return "deleteWishList";
       }else {
    	   myPageService.addWishListS(wishlistvo);
           log.info("## MypageController wishlist 등록 성공");
           return "addWishListS";
       }
    }
}
