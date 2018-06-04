package com.webshop.webapp.utils;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
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
import com.webshop.webapp.entity.Order;
import com.webshop.webapp.entity.service.OrderService;
import com.webshop.webapp.utils.IsThisCardRelatedToOngoingOrderChecker;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class IsThisCardRelatedToOngoingOrderCheckerTest {

	@InjectMocks
	private IsThisCardRelatedToOngoingOrderChecker checker;
	
	@Mock
	private OrderService orderServiceMock;
	
	@Mock
	private Order orderMock;
	
	@Test
	public void checkTrueTest() {
		
		List<Order> ongoingOrders = new ArrayList<>();
		ongoingOrders.add(orderMock);
		
		when(orderServiceMock.getOrdersByCreditCardId(1)).thenReturn(ongoingOrders);
		
		assertEquals(true,checker.check(1));
		
		verify(orderServiceMock).getOrdersByCreditCardId(1);
	}
	
	@Test
	public void checkFalseTest() {
		
		List<Order> ongoingOrders = new ArrayList<>();
		
		when(orderServiceMock.getOrdersByCreditCardId(1)).thenReturn(ongoingOrders);
		
		assertEquals(false,checker.check(1));
		
		verify(orderServiceMock).getOrdersByCreditCardId(1);
	}
	
}
