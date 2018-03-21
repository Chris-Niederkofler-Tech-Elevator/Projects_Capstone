package com.techelevator.pageObjects;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class SurveyInputPageObject {
	
	private WebDriver webDriver; 

	public SurveyInputPageObject(WebDriver webDriver) {
		// TODO Auto-generated constructor stub
	}
	
	public SurveyInputPageObject select_favorite_park(String parkName) {
		WebElement parkDropDropSelection = webDriver.findElement(By.id(parkName));
		parkDropDropSelection.click();
		return this;
	}
	
	public SurveyInputPageObject enter_an_email_address(String emailAddress) {
		WebElement emailInputForm = webDriver.findElement(By.id("emailaddress"));
		emailInputForm.sendKeys(emailAddress);	
		return this;
	}
	
	public SurveyInputPageObject select_a_state(String state) {
		WebElement stateDropDownMenu = webDriver.findElement(By.id(state));
		stateDropDownMenu.click();
		return this;
	}
	
	public SurveyInputPageObject select_an_activity_level(String activityLevel) {
		WebElement activityLevelRadioButtonMenu = webDriver.findElement(By.id(activityLevel));
		activityLevelRadioButtonMenu.click();
		return this;
	}
	
	public ParkResultsPageObject submit_survey() {
		
		WebElement submitButton = webDriver.findElement(By.id("survey_submit_button"));
		submitButton.click();
		return new ParkResultsPageObject(webDriver);	
	}

}
