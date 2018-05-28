package com.webshop.webapp.entity.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.webshop.webapp.entity.Review;

public interface ReviewService {

	public Review getReviewById(int reviewId);
	
	public List<Review> getReviewsByUserId(int userId);
	
	public List<Review> getReviewsByProductId(int productId);
	
	public void saveReview(Review review);

	public Page<Review> getReviewsByProductIdPageable(int productId,int page);
	
}
