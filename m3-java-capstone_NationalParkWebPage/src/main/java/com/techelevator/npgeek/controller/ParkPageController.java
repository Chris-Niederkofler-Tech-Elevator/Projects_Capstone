package com.techelevator.npgeek.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.dao.ParkDao;
import com.techelevator.npgeek.dao.WeatherDao;
import com.techelevator.npgeek.model.Weather;

@Controller
@SessionAttributes({"weatherInC", "weatherInF", "park", "isFahrenheit"})
public class ParkPageController {
	ParkDao dao;
	WeatherDao dao1;
	boolean isFahrenheit = true;
	
	
	
	 
	@Autowired
	ParkPageController(ParkDao dao, WeatherDao dao1){
	this.dao = dao;
	this.dao1 = dao1;
}
	@SuppressWarnings("unchecked")
	@RequestMapping(path = "/park", method = RequestMethod.GET)
	public String showParkPage(HttpServletRequest request, ModelMap model) {
	String parkId = request.getParameter("parkcode");
	model.addAttribute("park", dao.getParkByCode(parkId));
	List<Weather> weatherInF = new ArrayList<Weather>();
	weatherInF = dao1.getFiveDay(parkId);
	List<Weather> weatherInC = new ArrayList<Weather>();
	weatherInC = dao1.getCelciusConversion(dao1.getFiveDay(parkId)); //?passing in WeatherInF as the argument overwrites the original values in weatherInF
	model.addAttribute("weatherInF", weatherInF);		
	model.addAttribute("weatherInC", weatherInC);
	model.addAttribute("isFahrenheit", isFahrenheit);		
	if((boolean)model.get("isFahrenheit")) {
		model.addAttribute("weather", weatherInF);	
	}else {
		model.addAttribute("weather", weatherInC);	
	}

	return "park";
}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(path = "/park", method = RequestMethod.POST)
	public String showParkPageConversion(@RequestParam String convert , @RequestParam String parkcode, HttpServletRequest request, ModelMap model) {
		
		String parkId = request.getParameter("parkcode");
		model.addAttribute("park", dao.getParkByCode(parkId));
		
		if(convert.equals("C")) {
			//model.addAttribute("weather", ((List<Weather>)model.get("weatherInC")));
			isFahrenheit = false;
			model.addAttribute("isFahrenheit", isFahrenheit);	
			model.addAttribute("weather", model.get("weatherInC"));
			
		}else if(convert.equals("F")) {
			//model.addAttribute("weather", ((List<Weather>)model.get("weatherInF")));
			isFahrenheit = true;
			model.addAttribute("isFahrenheit", isFahrenheit);
			model.addAttribute("weather", model.get("weatherInF"));
			
		}
		else { //not needed if marked as not null
			//model.addAttribute("weather", ((List<Weather>)model.get("weather")));
			model.addAttribute("isFahrenheit", (boolean)model.get("isFahrenheit"));
		}
		
			return "park";
		
	}
	




}
//(List<Weather>)model.get("weather"))

