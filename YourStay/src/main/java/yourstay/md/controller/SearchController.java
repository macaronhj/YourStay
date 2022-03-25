package yourstay.md.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import yourstay.md.dao.interfaces.AccommodationDAO;

@Controller
public class SearchController {
	@Autowired
	AccommodationDAO adao;
	
	
}
