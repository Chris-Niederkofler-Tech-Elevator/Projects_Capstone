package com.techelevator.npgeek.dao;

import java.util.List;

import com.techelevator.npgeek.model.Favorites;
import com.techelevator.npgeek.model.SurveyPost;

public interface SurveyDao {

	public List<Favorites> getFavoritesPosts();
	public void save(SurveyPost post);
	List<SurveyPost> getFavoritePosts();
}

