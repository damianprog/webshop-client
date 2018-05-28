package com.webshop.webapp.webservice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.webshop.webapp.entity.Review;
import com.webshop.webapp.utils.HelperProductPage;
import com.webshop.webapp.utils.HelperReviewPage;

@Service
public class ReviewWebserviceImpl implements ReviewWebservice{

	@Autowired
	private RestTemplate restTemplate;
	
	private String url = "http://localhost:9000";
	
	@Override
	public Review getReviewById(int reviewId) {
		
		Map<String,Integer> params = new HashMap<>();
		params.put("reviewId", reviewId);
		
		return restTemplate.getForObject(url + "/reviews/{reviewId}", Review.class,params);
		
	}

	@Override
	public List<Review> getReviewsByUserId(int userId) {
		Map<String,Integer> params = new HashMap<>();
		params.put("userId", userId);
		
		ResponseEntity<Review[]> responseEntity = restTemplate.getForEntity(url + "/users/{userId}/reviews", Review[].class,params);
		return Arrays.asList(responseEntity.getBody());
	}

	@Override
	public List<Review> getReviewsByProductId(int productId) {
		Map<String,Integer> params = new HashMap<>();
		params.put("productId", productId);
		
		ResponseEntity<Review[]> responseEntity = restTemplate.getForEntity(url + "/products/{productId}/reviews", Review[].class,params);
		return Arrays.asList(responseEntity.getBody());
	}
	
	@Override
	public void saveReview(Review review) {
		restTemplate.put(url + "/reviews", review);
	}

	@Override
	public Page<Review> getReviewsByProductIdPageable(int productId,int page) {

		Map<String,Integer> params = new HashMap<>();
		params.put("productId", productId);
		params.put("page", page);
		
		HelperReviewPage helperReviewPage = restTemplate.getForObject(url + "/products/{productId}/reviews/{page}",
				HelperReviewPage.class, params);
		
		return helperReviewPage;
	}

}
