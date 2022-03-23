package yourstay.md.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import yourstay.md.domain.reviewVO;
import yourstay.md.mapper.ReviewMapper;
import yourstay.md.service.FileUploadService;

@Log4j
@AllArgsConstructor
@Controller
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	ReviewMapper mapper;
	@Autowired
	FileUploadService service;
	
//	@GetMapping(value="/registerReview")
//    public ModelAndView gohome(HttpSession session){
//        log.info("MypageController -> gohome 요청");
//        int vo = mapper.insertReview((reviewVO)session.getAttribute("memail"));
//        ModelAndView mv = new ModelAndView("mypage/home","member",vo);
//        return mv;
//    }
	
	   @PostMapping(value="/registerReview")
	   public ModelAndView addreview(HttpSession session, ArrayList<MultipartFile> files,@RequestParam String review) {
	      //작은미션: (멀티파트업로드) 구현! 
		  log.info("MypageController -> addreview 요청");
	      for(MultipartFile file : files) {
	         String ofname = file.getOriginalFilename();
	         if(ofname != null) ofname = ofname.trim();
	         if(ofname.length() != 0) {
	            String url = service.saveStore(file);
	         }
	      }
	    reviewVO vo = mapper.insertReview(files, review);
        ModelAndView mv = new ModelAndView("mypage/home","member",vo);
        log.info("####vo: "+vo);
        return mv;
	   }
}
