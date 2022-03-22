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
import yourstay.md.mapper.MemberMapper;
import yourstay.md.service.LoginService;
import static yourstay.md.domain.LoginConst.*;



@Log4j
@AllArgsConstructor
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	MemberMapper mapper;
	
	
	@GetMapping(value="/loginPage")
    public ModelAndView loginPage(ModelAndView mv){
        log.info("Logincontroller -> loginPage 로그인 시도 요청");
        mv.setViewName("login/loginPage");
        return mv;
    }
	@PostMapping("loginCheck.do")
    public ModelAndView loginCheck(@RequestParam String memail, String mpwd, HttpSession session, HttpServletRequest request){
        System.out.println(memail + "   " + mpwd);	
		boolean result = mapper.login(memail, mpwd);
        ModelAndView mav = new ModelAndView();
        if (result == true) { // 로그인 성공
            // main.jsp로 이동
            mav.setViewName("info/info");
            mav.addObject("msg", "success");
            session.setAttribute("memail", memail);
            session.setAttribute("mpwd", mpwd);
        } else {    // 로그인 실패
            // login.jsp로 이동
            mav.setViewName("login");
            mav.addObject("msg", "failure");
            session.setAttribute("memail", null);
            session.setAttribute("mpwd", null);
        }
        
        return mav;
    }
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.setAttribute("memail", null);
		session.setAttribute("mpwd", null);
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
	      System.out.println("ddd");
	      return mav;
      }
      else
      {
         mav.setViewName("login/joinPage");
         mav.addObject("msg","fail");
         System.out.println("cccc");
         return mav;
      }
   }
//	private void check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String memail = request.getParameter("memail");
//		String mpwd = request.getParameter("mpwd");
//		//유효성 검사(클라이언트측 View:js, 서버측 Controller:java)
//		System.out.println("email: "+memail+", pwd: "+mpwd);
//		
//		LoginService service = LoginService.getInstance();
//		int result = service.check(memail,mpwd);
//		System.out.println("result: "+result);
//		
//		if(result == YES_ID_PWD) {
//			MemberVO m = service.getMemberS(memail);
//			HttpSession session = request.getSession();
//			session.setAttribute("loginOkUser", m);
//		}
//		request.setAttribute("result", result);
//
//		ModelAndView mv = new ModelAndView("msg", "result", result);
//	}
}
