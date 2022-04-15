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
public class MypageRestController {
	@Autowired
	private AccommodationService accommodationService;
	@Autowired
	private MyPageService myPageService;
	@Autowired
	private MemberService memberService;
	
	@PostMapping(value = "/register.do")
	   public ModelAndView roomRegister(ModelAndView mv, roomRegisterVO roomregisterVo,
	         MultipartHttpServletRequest mpRequest) throws Exception {
	      log.info("roomOption Data -> info ����");
	      log.info("mpRequest : " +  mpRequest);
	      accommodationService.insertAccommodationS(roomregisterVo, mpRequest);
	      log.info("roomregisterVo: " + roomregisterVo);
	      mv.setViewName("redirect:/mypage/home");
	      return mv;
	   }
	@PostMapping(value = "/modifyRoom")
    public ModelAndView modifyRoom(ModelAndView mv, roomRegisterVO roomregisterVo,
      MultipartHttpServletRequest mpRequest) throws Exception {
      log.info("#modifyRoom ����");
      log.info("#roomregisterVo aid: "+roomregisterVo.getAid());
      accommodationService.updateAccommodationS(roomregisterVo, mpRequest);
      log.info("roomregisterVo: " + roomregisterVo);
      mv.setViewName("redirect:/mypage/home");
      return mv;
   }
    @PostMapping(value = "/delete")
    public ModelAndView requestDelete(ModelAndView mv, Long aid){
    	log.info("[MypageController -> aid]: "+aid);
        log.info("[MypageController -> requestDelete ����Ʈ ���� ��û��]");
        accommodationService.requestDelete(aid);
        mv.setViewName("redirect:/mypage/home");
        return mv;
    }
    @PostMapping("updateUser.do")
	public ModelAndView updateMember(ModelAndView mv, long mseq, String mname, String memail, String mpwd, int mcallnum) {
        MemberVO member = new MemberVO(mseq, mname, memail, mpwd, mcallnum, 0);

		log.info("mseq getMseq �� : " + member.getMseq()); // ������� ��! 
		log.info("mseq getMname �� : " + member.getMname());
		log.info("mseq getMemail �� : " + member.getMemail());
		log.info("mseq getMpwd �� : " + member.getMpwd());
		log.info("mseq getMcallnum �� : " + member.getMcallnum());
		
		log.info("####memberVO : " + member);
	
		int updateResult = memberService.updateUser(member);
		log.info("11111111111111");
		if(updateResult>0) {
			log.info("Member Update ����");
		}else {
			log.info("Member Update ����");
		}
		mv.setViewName("redirect:/mypage/home");
		return mv;
	}
    @PostMapping("removeUser.do")
	public ModelAndView removeUser(ModelAndView mv, String memail, HttpSession session) {
		int result = memberService.removeUser(memail);
		if(result>0) {
			log.info("## Controller removeUser ����!!");
			session.invalidate();
		}else {
			log.info("## Controller removeUser ����!!");
		}
		mv.setViewName("redirect: /");
		return mv;
	}
	/*
	 * ���ϱ� �κ� �߰� TEst
	 */	
	@ResponseBody
	@PostMapping(value="/wishlist/addwish")
	public String addWishList(HttpSession session, WishListVO wishlistvo) {
       log.info("!@@@@@@@@@wishlistvo : " + wishlistvo);
       boolean findResult = myPageService.findWishListS(wishlistvo);
       if(findResult) {
    	   myPageService.deleteWishListS(wishlistvo);
    	   log.info("## Controller deleteWishList ���� ����!!!!!!!!!!!!");
    	   return "deleteWishList";
       }else {
    	   myPageService.addWishListS(wishlistvo);
           log.info("## Controller wishlist ��� ����");
           return "addWishListS";
       }
    }
}
