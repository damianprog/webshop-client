package com.webshop.webapp.utils;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Review;

@Component
public class ReviewsSorter {

	public List<Review> sortReviewsDescending(List<Review> reviews) {
		
		reviews.sort(Comparator.comparingInt(Review::getId).reversed());
		
		return reviews;
	}
	
}
