package com.webshop.webapp.entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webshop.webapp.entity.Rating;
import com.webshop.webapp.webservice.RatingWebservice;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingWebservice ratingWebservice;
	
	@Override
	public Rating getRatingById(int ratingId) {
		return ratingWebservice.getRatingById(ratingId);
	}

	@Override
	public List<Rating> getRatingsByUserId(int userId) {
		return ratingWebservice.getRatingsByUserId(userId);
	}

	@Override
	public List<Rating> getRatingsByProductId(int productId) {
		return ratingWebservice.getRatingsByProductId(productId);
	}

	@Override
	public void saveRating(Rating rating) {
		ratingWebservice.saveRating(rating);
	}

}
