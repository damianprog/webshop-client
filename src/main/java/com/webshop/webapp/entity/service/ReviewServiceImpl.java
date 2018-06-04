package com.webshop.webapp.entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.webshop.webapp.entity.Review;
import com.webshop.webapp.webservice.ReviewWebservice;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewWebservice reviewWebservice;
	
	@Override
	public Review getReviewById(int reviewId) {
		return reviewWebservice.getReviewById(reviewId);
	}

	@Override
	public List<Review> getReviewsByUserId(int userId) {
		return reviewWebservice.getReviewsByUserId(userId);
	}

	@Override
	public List<Review> getReviewsByProductId(int productId) {

		return reviewWebservice.getReviewsByProductId(productId);
		
	}

	@Override
	public void saveReview(Review review) {
		reviewWebservice.saveReview(review);
	}

	@Override
	public Page<Review> getReviewsByProductIdPageable(int productId,int page) {
		return reviewWebservice.getReviewsByProductIdPageable(productId,page);
	}

}
