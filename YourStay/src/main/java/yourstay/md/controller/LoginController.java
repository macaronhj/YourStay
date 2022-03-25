package yourstay.md.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import yourstay.md.domain.resultVO;
import yourstay.md.mapper.MemberMapper;
import yourstay.md.mapper.SearchMapper;

import static yourstay.md.domain.LoginConst.*;



@Log4j
@AllArgsConstructor
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	MemberMapper mapper;
	
	@Autowired
	SearchMapper searchMapper;
	
	
	@GetMapping(value="/loginPage")
    public ModelAndView loginPage(ModelAndView mv){
        log.info("Logincontroller -> loginPage 로그인 시도 요청");
        mv.setViewName("login/loginPage");
        return mv;
    }
//	@PostMapping("loginCheck.do")
//    public ModelAndView loginCheck(@RequestParam String memail, String mpwd, HttpSession session, HttpServletRequest request){
//        System.out.println(memail + "   " + mpwd);	
//		boolean result = mapper.login(memail, mpwd);
//        ModelAndView mav = new ModelAndView();
//        if (result == true) { // 로그인 성공
//            // main.jsp로 이동
//            mav.setViewName("info/info");
//            mav.addObject("msg", "success");
//            session.setAttribute("memail", memail);
//            session.setAttribute("mpwd", mpwd);
//        } else {    // 로그인 실패
//            // login.jsp로 이동
//            mav.setViewName("login");
//            mav.addObject("msg", "failure");
//            session.setAttribute("memail", null);
//            session.setAttribute("mpwd", null);
//        }
//        
//        return mav;
//    }
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		log.info("로그아웃 세션 null처리");
//		session.setAttribute("memail", null);
//		session.setAttribute("mpwd", null);
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping(value="/joinPage")
    public ModelAndView requestJoin(ModelAndView mv){
        log.info("Logincontroller -> requestLogin 로그인 시도 요청");
        mv.setViewName("login/joinPage");
        return mv;
    }
	@RequestMapping("join.do")
	public ModelAndView join(@RequestParam String mname, String memail, String mpwd, int mcallnum) {
   
	   MemberVO memberVo = mapper.getUser(memail);
	   ModelAndView mav = new ModelAndView();
	   if(memberVo == null)
	   {
	    mapper.addUser(new MemberVO(-1, mname, memail, mpwd , mcallnum, -1));
		   mav.setViewName("login/loginPage");
	      mav.addObject("msg","success");
	      log.info("ddd");
	      return mav;
      }
      else
      {
         mav.setViewName("login/joinPage");
         mav.addObject("msg","fail");
         log.info("cccc");
         return mav;
      }
   }
	@PostMapping("loginCheck.do")
	private ModelAndView check(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws ServletException, IOException {
		String memail = request.getParameter("memail");
		String mpwd = request.getParameter("mpwd");
		ModelAndView mv = new ModelAndView();
		//유효성 검사(클라이언트측 View:js, 서버측 Controller:java)
		log.info("loginCon check //email: "+memail+", pwd: "+mpwd);
		int result = mapper.login(memail, mpwd);
		log.info("로그인 결과(1>성공) : " + result);		
		
		if(result == YES_ID_PWD) { //로그인 성공시
			log.info("로그인 성공");	
			mv.setViewName("index");
			MemberVO m = mapper.getUser(memail);
			session = request.getSession();
			mv.addObject("msg", "success");
			session.setAttribute("memail", memail);
			session.setAttribute("loginOkUser", m);
			log.info("m: "+m);
//			resultVO resVO = searchMapper.getAccommodationByAccommodationId(aid);
//	        System.out.println(resVO.toString()); 
//	        new ModelAndView("info/info","resVO",resVO);
		}else { // 로그인 실패시
			log.info("로그인 실패");
			mv.setViewName("login_check_module");
		}
		return mv;
	}
}
