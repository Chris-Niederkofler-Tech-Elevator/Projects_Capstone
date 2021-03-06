package com.techelevator;


import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import com.techelevator.npgeek.dao.SurveyDao;
import com.techelevator.npgeek.model.SurveyPost;


public abstract class DAOIntegrationTest {

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	SurveyDao surveyDao;
	
	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/* The following line disables autocommit for connections 
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);
	}
	
	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void try_to_add_survey(){
		
		SurveyPost survey = new SurveyPost();
		survey.setActivityLevel("moderate");
		survey.setEmailAddress("parkgeek@gmail.com");
		survey.setParkCode("CVNP");
		survey.setState("CA");
		survey.setSurveyId(100);
		surveyDao.save(survey);
		//Assert.assertTrue(survey.compareSurvey( // past in the result of pulling id100 from db 
				//surveyDao.getAllPosts().get));
				
	}
	
	/* This method provides access to the DataSource for subclasses so that 
	 * they can instantiate a DAO for testing */
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public boolean compareSurvey(SurveyPost survey) {
		//compare each local variable of the object passed and the object called method
		
		return false;
		
	}
}
