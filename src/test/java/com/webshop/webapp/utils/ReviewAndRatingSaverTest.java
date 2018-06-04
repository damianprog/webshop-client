package com.webshop.webapp.utils;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.webshop.webapp.Application;
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
import com.webshop.webapp.utils.ReviewAndRatingSaver;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class ReviewAndRatingSaverTest {

	@InjectMocks
	private ReviewAndRatingSaver reviewAndRatingSaver;
	
	@Mock
	private HttpSession session;
	
	@Mock
	private UserService userServiceMock;

	@Mock
	private ProductService productServiceMock;

	@Mock
	private ReviewService reviewServiceMock;

	@Mock
	private RatingService ratingServiceMock;

	@Mock
	private User userMock;
	
	@Mock
	private ReviewAndRating reviewAndRatingMock;
	
	@Mock
	private Product productMock;
	
	@Mock
	private RatingFactory ratingFactory;
	
	@Mock
	private Review reviewMock;
	
	@Mock
	private Rating ratingMock;

	@Test
	public void saveTest() {
		
		when(session.getAttribute("userId")).thenReturn(1);
		when(userServiceMock.getUserById(1)).thenReturn(userMock);
		when(reviewAndRatingMock.getProductId()).thenReturn(2);
		when(productServiceMock.getProductById(2)).thenReturn(productMock);
		when(ratingFactory.createInstance()).thenReturn(ratingMock);
		when(reviewAndRatingMock.getRating()).thenReturn(5);
		when(reviewAndRatingMock.getReview()).thenReturn(reviewMock);
		
		reviewAndRatingSaver.save(reviewAndRatingMock);
		
		verify(session).getAttribute("userId");
		verify(userServiceMock).getUserById(1);
		verify(reviewAndRatingMock).getProductId();
		verify(productServiceMock).getProductById(2);
		verify(ratingFactory).createInstance();
		verify(reviewAndRatingMock).getRating();
		verify(reviewAndRatingMock).getReview();
		verify(ratingMock).setProduct(productMock);
		verify(ratingMock).setRate(5);
		verify(ratingMock).setUser(userMock);
		verify(reviewMock).setProduct(productMock);
		verify(reviewMock).setRating(ratingMock);
		verify(reviewMock).setUser(userMock);
		verify(reviewMock).setDate(String.valueOf(LocalDate.now()));
		verify(reviewServiceMock).saveReview(reviewMock);
		verify(ratingServiceMock).saveRating(ratingMock);
		
	}
	
}
