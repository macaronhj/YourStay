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
@RequestMapping("/acco")
public class AccoController {
	@GetMapping(value="/detailInfo")
    public ModelAndView detailInfo(ModelAndView mv){
        log.info("AccoController -> detailInfo 로그인 시도 요청");
        mv.setViewName("info/info");
        return mv;
    }
}
