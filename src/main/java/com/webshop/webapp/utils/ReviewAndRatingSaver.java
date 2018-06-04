package com.webshop.webapp.utils;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.Product;
import com.webshop.webapp.entity.Rating;
import com.webshop.webapp.entity.Review;
import com.webshop.webapp.entity.ReviewAndRating;
import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.service.ProductService;
import com.webshop.webapp.entity.service.RatingService;
import com.webshop.webapp.entity.service.ReviewService;
import com.webshop.webapp.entity.service.UserService;
import com.webshop.webapp.factories.RatingFactory;

@Component
public class ReviewAndRatingSaver {

	@Autowired
	private HttpSession session;

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private RatingService ratingService;

	@Autowired
	private RatingFactory ratingFactory;
	
	private Review review;

	private Rating rating;

	public void save(ReviewAndRating rat) {

		initializeReviewAndRating(rat);

		reviewService.saveReview(review);
		ratingService.saveRating(rating);

	}
	
	private void initializeReviewAndRating(ReviewAndRating rat) {

		int userId = (int) session.getAttribute("userId");
		User user = userService.getUserById(userId);
		Product product = productService.getProductById(rat.getProductId());

		rating = ratingFactory.createInstance();
		rating.setProduct(product);
		rating.setRate(rat.getRating());
		rating.setUser(user);

		review = rat.getReview();
		review.setProduct(product);
		review.setRating(rating);
		review.setUser(user);
		review.setDate(String.valueOf(LocalDate.now()));

	}

}
