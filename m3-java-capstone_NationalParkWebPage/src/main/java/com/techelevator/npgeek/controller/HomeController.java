package com.techelevator.npgeek.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.npgeek.dao.ParkDao;
import com.techelevator.npgeek.model.Park;
@Controller
public class HomeController {


	ParkDao dao;
	


	
	@Autowired
	HomeController(ParkDao dao){
	this.dao = dao;
	}
	

	

		@RequestMapping(path = "/home", method = RequestMethod.GET)
		public String showHomePage(HttpServletRequest request, ModelMap model) {
	
		
		List<Park> parks = new ArrayList<>();
		parks = dao.getAllParks();
		
		model.addAttribute("parks", parks);
		
		return "home";

}
}



	

