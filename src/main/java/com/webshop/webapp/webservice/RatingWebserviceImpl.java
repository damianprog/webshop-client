package com.webshop.webapp.webservice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.webshop.webapp.entity.Rating;

@Service
public class RatingWebserviceImpl implements RatingWebservice {

	@Autowired
	private RestTemplate restTemplate;

	private String url = "http://localhost:9000";

	@Override
	public Rating getRatingById(int ratingId) {

		Map<String, Integer> params = new HashMap<>();
		params.put("ratingId", ratingId);

		return restTemplate.getForObject(url + "/rating/{ratingId}", Rating.class, params);

	}

	@Override
	public List<Rating> getRatingsByUserId(int userId) {

		Map<String, Integer> params = new HashMap<>();
		params.put("userId", userId);

		ResponseEntity<Rating[]> responseEntity = restTemplate.getForEntity(url + "/users/{userId}/ratings", Rating[].class,
				params);
		
		return Arrays.asList(responseEntity.getBody());

	}

	@Override
	public List<Rating> getRatingsByProductId(int productId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);

		ResponseEntity<Rating[]> responseEntity = restTemplate.getForEntity(url + "/products/{productId}/ratings", Rating[].class,
				params);
		
		return Arrays.asList(responseEntity.getBody());
	}

	@Override
	public void saveRating(Rating rating) {
		restTemplate.put(url + "/ratings", rating);
	}

}
