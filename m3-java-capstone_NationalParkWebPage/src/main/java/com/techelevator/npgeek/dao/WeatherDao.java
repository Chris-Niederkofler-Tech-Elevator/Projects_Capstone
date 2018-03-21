package com.techelevator.npgeek.dao;




import java.util.List;

import com.techelevator.npgeek.model.Weather;

public interface WeatherDao {

	public List<Weather> getFiveDay(String parkCode);
	public List<Weather> getCelciusConversion(List<Weather> weather);
	public List<Weather> getFahrenheitConversion(List<Weather> weather);
	
	}
	

