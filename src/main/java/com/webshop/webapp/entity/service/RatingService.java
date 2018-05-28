package com.webshop.webapp.entity.service;

import java.util.List;

import com.webshop.webapp.entity.Rating;

public interface RatingService {

	public Rating getRatingById(int ratingId);
	
	public List<Rating> getRatingsByUserId(int userId);
	
	public List<Rating> getRatingsByProductId(int productId);
	
	public void saveRating(Rating rating);
	
}
