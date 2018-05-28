package com.webshop.webapp.webservice;

import java.util.List;

import com.webshop.webapp.entity.Rating;

public interface RatingWebservice {

	public Rating getRatingById(int ratingId);

	public List<Rating> getRatingsByUserId(int userId);

	public List<Rating> getRatingsByProductId(int productId);

	public void saveRating(Rating rating);

}
