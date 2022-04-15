package yourstay.md.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;
import yourstay.md.domain.Accommodation;
import yourstay.md.service.SearchService;

@Log4j
@Controller
public class MainController {
	@Autowired
	SearchService searchService;
	
   @GetMapping("/")
   public ModelAndView index() {
      List<Accommodation> vo = searchService.getAccommodationByLoc();
      log.info("MainController index: "+vo);
      return new ModelAndView("index", "vo" , vo);
   }
   @GetMapping("/review")
   public String review() {
      return "review";
   }
   
}