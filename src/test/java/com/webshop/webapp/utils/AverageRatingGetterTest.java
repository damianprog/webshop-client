package com.webshop.webapp.utils;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.webshop.webapp.Application;
import com.webshop.webapp.entity.Rating;
import com.webshop.webapp.entity.service.RatingService;
import com.webshop.webapp.utils.AverageRatingGetter;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class AverageRatingGetterTest {

	@InjectMocks
	private AverageRatingGetter averageRatingGetter;
	
	@Mock
	private RatingService ratingServiceMock;
	
	@Test
	public void getTest() {
		
		when(ratingServiceMock.getRatingsByProductId(1)).thenReturn(prepareRatingsForTest());
		
		assertEquals(averageRatingGetter.get(1),3,0);
		
	}
	
	private List<Rating> prepareRatingsForTest() {
		
		List<Rating> ratingsList = new ArrayList<>();
		
		for(int i=1;i<6;i++) {
			
			Rating rating = new Rating();
			rating.setRate(i);
			
			ratingsList.add(rating);
			
		}
		
		
		return ratingsList;
	}
	
}
