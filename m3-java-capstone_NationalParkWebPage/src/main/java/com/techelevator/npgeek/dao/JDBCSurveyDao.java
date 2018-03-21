package com.techelevator.npgeek.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Favorites;
import com.techelevator.npgeek.model.SurveyPost;

@Component
public class JDBCSurveyDao implements SurveyDao {

	private JdbcTemplate jdbcTemplate;

	public JDBCSurveyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	


	@Override
	public List<Favorites> getFavoritesPosts() {
		List<Favorites> allPosts = new ArrayList<>();
		String sqlSelectAllPosts = "SELECT survey_result.parkcode , park.parkname, COUNT(survey_result.parkcode) FROM survey_result " + 
				"FULL OUTER JOIN park ON park.parkcode = survey_result.parkcode " + 
				"WHERE survey_result.parkcode IS NOT NULL " + 
				"GROUP BY survey_result.parkcode , park.parkname ORDER BY COUNT(survey_result.parkcode) DESC, " + 
				"(park.parkname)" ;
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllPosts);
		while(results.next()) {
			Favorites park = new Favorites();
			
			park.setParkName(results.getString("parkname"));
			park.setCount(results.getInt("count"));
			park.setParkCode(results.getString("parkcode"));
			allPosts.add(park);
		}
		return allPosts;
	}

	@Override
	public void save(SurveyPost post) {
		Integer id = getNextId();
		//TBD
		String sqlInsertPost = "INSERT INTO survey_result(surveyid, parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sqlInsertPost, id, post.getParkCode(), post.getEmailAddress(), post.getState(), post.getActivityLevel());
		post.setSurveyId(id);
	}

	private Integer getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_surveyId')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		Integer id = null;
		if(results.next()) {
			id = results.getInt(1);
		} else {
			throw new RuntimeException("Something strange happened, unable to select next survey id from sequence");
		}
		return id;
	}



	@Override
	public List<SurveyPost> getFavoritePosts() {
		// TODO Auto-generated method stub
		return null;
	}



//	@Override
//	public List<SurveyPost> getFavoritesPosts() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}

