package com.techelevator;


import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.AfterClass;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.techelevator.npgeek.dao.SurveyDao;
import com.techelevator.pageObjects.*;


public class NpGeekWebTest {

	private static WebDriver webDriver;
	private HomePageObject homePage;
	private SurveyDao surveyDao;
	
	
	/* Creating an instance of the WebDriver is time consuming
	 * since it opens up a browser window. Therefore, we do this
	 * only once at the start of the class and reuse the same
	 * browser window for all tests. */
	@BeforeClass
	public static void openWebBrowserForTesting() {
		
		String homeDir = System.getProperty("user.home");
		/* The ChromeDriver requires a system property with the name "webdriver.chrome.driver" that
		 * contains the directory path to the ChromeDriver executable. The following line assumes
		 * we have installed the ChromeDriver in a known location under our home directory */
		System.setProperty("webdriver.chrome.driver", homeDir+"/dev-tools/chromedriver/chromedriver");
		webDriver = new ChromeDriver();
	}
	
	@Before
	public void openHomePage() {
		webDriver.get("http://localhost:8080/ssg-exercises-pair/");
		homePage = new HomePageObject(webDriver);
	}
	
	@AfterClass
	public static void closeWebBrowser() {
		webDriver.close();
	}
	
	@Test
	public void go_to_the_park_detail_page() { //CORRECT ASSERTION AND TEST SETUP
		
		homePage.selectParkDetailPage("AparkCode");
		WebElement title = webDriver.findElement(By.id("Parks"));
		assertEquals("Parks Details", title.getText());
		
	}

//	WebElement savingsH2 = webDriver.findElement(By.id("savings"));
//	assertEquals("Start Saving", savingsH2.getText());

	@Test
	public void submit_a_survey() { //CORRECT INPUT VALUES BELOW
									homePage.selectSurveyLink()
									.select_favorite_park("AparkName")
									.enter_an_email_address("AnemailAddress")
									.select_a_state("AStateName")
									.select_an_activity_level("sedentary")
									.submit_survey();
		
		//may need to add a method to surveyDao to get post by id and or 
		//determine a different way to verify the survey was written
		//may need a dummy survey object created here and compare to method 
		//created below to compare the two															
		//assertEquals(surveyDao.getAllPosts());								
		
	}	
		
	
}
