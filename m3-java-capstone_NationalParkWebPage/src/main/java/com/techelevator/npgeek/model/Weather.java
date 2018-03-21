package com.techelevator.npgeek.model;

public class Weather {
	
	private String parkCode;
	private int day;
	private double lowTemp;
	private double highTemp;
	private String forecast;
	private String weatherMessage;
	


	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public double getLowTemp() {
		return lowTemp;
	}
	public void setLowTemp(double lowTemp) {
		this.lowTemp = lowTemp;
	}
	public double getHighTemp() {
		return highTemp;
	}
	public void setHighTemp(double highTemp) {
		this.highTemp = highTemp;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	public String getWeatherMessage() {
		if(forecast.equals("snow")) {
			weatherMessage = "Pack snowshoes Polar Bear! ";
		}else if(forecast.equals("rain")) {
			weatherMessage = "Pack Your Rain Gear and Wear WaterProof Shoes! ";
		}else if(forecast.equals("thunderstorms")) {
			weatherMessage = "If you hear Thunder, Seek Shelter Immediately and Avoid Exposed Ridges! ";
		}else if(forecast.equals("sunny")) {
			weatherMessage = "Don't forget your Sunblock! ";
		}
	if(highTemp > 75) {
		weatherMessage += "Bring an extra Gallon of H20! ";
	}
	if(lowTemp < 20) {
		weatherMessage += "WARNING! Jack Nicholson's fate in 'The Shining' may happen to you!!! ";
	}
	if((highTemp - lowTemp) > 20) {
		weatherMessage += "Wear Breathable Layers! ";
	}
		
		return weatherMessage;
	}
	public void setWeatherMessage(String weatherMessage) {
		this.weatherMessage = weatherMessage;
	}
	
	
	

}

