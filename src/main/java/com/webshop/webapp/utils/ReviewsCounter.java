package com.webshop.webapp.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Review;
import com.webshop.webapp.entity.service.ReviewService;

@Component
public class ReviewsCounter {

	@Autowired
	private ReviewService reviewService;
	
	public int howManyReviews(int productId) {
		
		List<Review> reviews = reviewService.getReviewsByProductId(productId);
		
		return reviews.size();
	}
	
}
