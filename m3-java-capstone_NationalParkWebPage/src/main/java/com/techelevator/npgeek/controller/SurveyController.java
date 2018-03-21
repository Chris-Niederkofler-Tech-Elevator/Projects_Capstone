package com.techelevator.npgeek.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.dao.ParkDao;
import com.techelevator.npgeek.dao.SurveyDao;
import com.techelevator.npgeek.model.SurveyPost;

@Controller

public class SurveyController {
	
	SurveyDao surveyDao;
	ParkDao parkDao;
	
	@Autowired
	SurveyController(SurveyDao surveyDao, ParkDao parkDao){
		this.surveyDao = surveyDao;
		this.parkDao = parkDao;
	}
	
	@RequestMapping(path = "/surveyInput", method = RequestMethod.GET)
		
	public String showSurveyInputPage(HttpServletRequest request, Model map) {

		//For the states and park options to be visible on the page the lists/associated objects must be
		//declared in the get
		//POST version on the request mapping will be used to set the values receiving the answers 
		List<String> stateList = new ArrayList<String>();
		Collections.addAll(stateList, "Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut",
				"Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas",
				"Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota",
				"Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey",
				"New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon",
				"Pennsylvania","Rhode Island","South Carolina","SouthDakota","Tennessee","Texas","Utah",
				"Vermont","Virginia","Washington","West Virginia","Wisconsin", "Wyoming");
			
		request.setAttribute("listOfStates", stateList);
		request.setAttribute("listOfParks", parkDao.getAllParks());
		
		return "surveyInput";
	}
	
	@RequestMapping(path = "/surveyInput", method = RequestMethod.POST)
	public String processSurveySubmission(@Valid @ModelAttribute("survey") SurveyPost survey, BindingResult result, HttpServletRequest request)
	throws FileNotFoundException, IOException {
	
	    //SurveyPost survey = new SurveyPost();
	    
	    if(result.hasErrors()) {
	        return "redirect:/surveyInput";
	    }
	   
		
//		SurveyPost survey = new SurveyPost();
		
//		survey.setActivityLevel(request.getParameter("activitylevel"));
//		survey.setEmailAddress(request.getParameter("emailaddress"));
//		survey.setParkCode(request.getParameter("parkcode"));
//		survey.setState(request.getParameter("state"));
	

		surveyDao.save(survey);
			return "redirect:/surveyResults";
	}

	@RequestMapping(path = "/surveyResults", method = RequestMethod.GET)
	public String displayFavoriteParks(ModelMap map) {
		
		map.addAttribute("favorites", surveyDao.getFavoritesPosts());
	
		
		return "surveyResults";
	}

}
	

