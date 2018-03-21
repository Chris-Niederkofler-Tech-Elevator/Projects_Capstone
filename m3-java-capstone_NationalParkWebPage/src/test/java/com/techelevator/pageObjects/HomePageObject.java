package com.techelevator.pageObjects;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class HomePageObject {

	private WebDriver webDriver; 


	public HomePageObject(WebDriver webDriver) {
		// TODO Auto-generated constructor stub
	}
	
	public ParkPageObject selectParkDetailPage(String parkCode) {
		WebElement parkImage = webDriver.findElement(By.id(parkCode));
		parkImage.click();
		return new ParkPageObject(webDriver);
	}
	
	public SurveyInputPageObject selectSurveyLink() {
		WebElement surveyLinkButton = webDriver.findElement(By.linkText("Survey"));
		surveyLinkButton.click();
		return new SurveyInputPageObject(webDriver);
	}

}
