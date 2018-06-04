package com.webshop.webapp.utils;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.webshop.webapp.Application;
import com.webshop.webapp.utils.DeliveryCostCounter;
import com.webshop.webapp.utils.service.CartService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class DeliveryCostCounterTest {

	@InjectMocks
	private DeliveryCostCounter deliveryCostCounter;
	
	@Mock
	private CartService cartService;
	
	private double overallCartProductsPrice = 50;
	
	private double deliveryCost = 10;
	
	@Test
	public void countPaidOrderTest() {
		
		when(cartService.countOverallCartProductsPrice()).thenReturn(overallCartProductsPrice);
		
		assertEquals(deliveryCostCounter.count("Two-day shipping"),deliveryCost,0);
		
		verify(cartService).countOverallCartProductsPrice();
		
	}
	
}
