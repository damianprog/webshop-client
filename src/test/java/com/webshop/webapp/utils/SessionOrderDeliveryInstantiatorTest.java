package com.webshop.webapp.utils;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.webshop.webapp.Application;
import com.webshop.webapp.entity.Delivery;
import com.webshop.webapp.entity.Order;
import com.webshop.webapp.enumeration.DeliveryTypes;
import com.webshop.webapp.factories.DeliveryFactory;
import com.webshop.webapp.utils.DeliveryCostCounter;
import com.webshop.webapp.utils.SessionOrderDeliveryInstantiator;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class SessionOrderDeliveryInstantiatorTest {

	@InjectMocks
	private SessionOrderDeliveryInstantiator sessionOrderDeliveryInstantiator;
	
	@Mock
	private HttpSession sessionMock;

	@Mock
	private DeliveryCostCounter deliveryCostCounterMock;
	
	@Mock
	private Order orderMock;
	
	@Mock
	private Delivery deliveryMock;
	
	@Mock
	private DeliveryFactory deliveryFactoryMock;
	
	private String deliveryTypeName = DeliveryTypes.TWODAYSHIPPING.deliveryTypeName();
	
	private double deliveryPrice = 10;
	
	@Test
	public void instantiate() {
		
		when(sessionMock.getAttribute("order")).thenReturn(orderMock);
		when(deliveryFactoryMock.createInstance()).thenReturn(deliveryMock);
		when(deliveryCostCounterMock.count(deliveryTypeName)).thenReturn(deliveryPrice);
		
		sessionOrderDeliveryInstantiator.instantiate(deliveryTypeName);
		
		verify(sessionMock).getAttribute("order");
		verify(deliveryFactoryMock).createInstance();
		verify(deliveryCostCounterMock).count(deliveryTypeName);
		verify(deliveryMock).setDeliveryDate(String.valueOf(LocalDate.now().plusDays(3)));
		verify(deliveryMock).setDeliveryCost(deliveryPrice);
		verify(orderMock).setDelivery(deliveryMock);
		
		
	}
	
}
