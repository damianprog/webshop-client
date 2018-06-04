package com.webshop.webapp.utils;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.webshop.webapp.Application;
import com.webshop.webapp.entity.Review;
import com.webshop.webapp.entity.service.ReviewService;
import com.webshop.webapp.utils.ReviewsCounter;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class ReviewsCounterTest {

	@InjectMocks
	private ReviewsCounter reviewsCounter;
	
	@Mock
	private ReviewService reviewServiceMock;
	
	@Mock
	private Review reviewMock;

	@Mock
	private List<Review> reviewsListMock;
	
	private int productId = 1;
	
	private int reviewsListMockSize = 2;
	
	@Test
	public void howManyReviewsTest() {
		
		when(reviewServiceMock.getReviewsByProductId(productId)).thenReturn(reviewsListMock);
		when(reviewsListMock.size()).thenReturn(reviewsListMockSize);
		
		assertEquals(reviewsListMockSize,reviewsCounter.howManyReviews(productId));
		
		verify(reviewServiceMock).getReviewsByProductId(productId);
		verify(reviewsListMock).size();
		
	}
	
}
