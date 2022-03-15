package yourstay.md.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import yourstay.md.domain.MemberVO;
import yourstay.md.service.MemberService;

@Log4j
@AllArgsConstructor
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Inject
	MemberService service;
	
	@GetMapping(value="/loginPage")
    public ModelAndView loginPage(ModelAndView mv){
        log.info("Logincontroller -> loginPage 로그인 시도 요청");
        mv.setViewName("login/loginPage");
        return mv;
    }
	@PostMapping(value="/loginPage")
	public String login(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
        log.info("Logincontroller -> requestLogin 로그인 시도 요청");
        HttpSession session = req.getSession();
		MemberVO member = service.login(vo);
		
		if(member == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		}else {
			session.setAttribute("member", member);
		}
		
		return "redirect:/";
	}
	@GetMapping(value="/joinPage")
    public ModelAndView requestJoin(ModelAndView mv){
        log.info("Logincontroller -> requestLogin 로그인 시도 요청");
        mv.setViewName("login/joinPage");
        return mv;
    }
}
