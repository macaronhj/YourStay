package yourstay.md.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import yourstay.md.controller.InfoController;
import yourstay.md.domain.Accommodation;
import yourstay.md.service.InfoService;

@Log4j
@AllArgsConstructor
@Controller
@RequestMapping("/info")
public class InfoController {
	@Autowired
	private InfoService infoService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home() {
		log.info("홈페이지 이동");
		return "info/info";
	}
	
//	@GetMapping("show.do")
//	public ModelAndView showInfo(long aid) {
//		Accommodation accomm = infoService.selectAccommodation(aid);
//		ModelAndView mv = new ModelAndView("", "accomm", accomm);
//		return mv;
//	}
	

}
