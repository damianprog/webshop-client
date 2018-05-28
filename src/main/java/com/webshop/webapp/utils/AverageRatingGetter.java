package com.webshop.webapp.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Rating;
import com.webshop.webapp.entity.service.RatingService;

@Component
public class AverageRatingGetter {
	
	@Autowired
	private RatingService ratingService;
	
	public double get(int productId) {
		
		List<Rating> ratings = ratingService.getRatingsByProductId(productId);
		
		if(ratings.size() == 0)
			return 0;
		
		return countAverage(ratings);
		
	}

	private double countAverage(List<Rating> ratings) {
		double sum = 0;
		double averageRating = 0;
		
		for(Rating rating:ratings) 
			sum += rating.getRate();			
		
		averageRating = sum/ratings.size();
		return averageRating;
	}
	
}
