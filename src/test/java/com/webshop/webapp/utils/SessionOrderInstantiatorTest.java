package com.webshop.webapp.utils;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.webshop.webapp.Application;
import com.webshop.webapp.entity.Cart;
import com.webshop.webapp.entity.CartProduct;
import com.webshop.webapp.entity.Order;
import com.webshop.webapp.factories.OrderFactory;
import com.webshop.webapp.utils.SessionOrderInstantiator;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class SessionOrderInstantiatorTest {

	@InjectMocks
	private SessionOrderInstantiator sessionOrderInstantiator;
	
	@Mock
	private HttpSession sessionMock;

	@Mock
	private Cart cartMock;
	
	@Mock
	private OrderFactory orderFactoryMock;
	
	@Mock
	private Order orderMock;
	
	@Mock
	private ArrayList<CartProduct> cartProductsMock;
	
	@Test
	public void instantiate(){

		when(sessionMock.getAttribute("cart")).thenReturn(cartMock);
		when(orderFactoryMock.createInstance()).thenReturn(orderMock);
		when(cartMock.getCartProducts()).thenReturn(cartProductsMock);
		
		sessionOrderInstantiator.instantiate();
		
		verify(sessionMock).getAttribute("cart");
		verify(orderFactoryMock).createInstance();
		verify(cartMock).getCartProducts();
		verify(orderMock).setCartProducts(cartProductsMock);
		verify(orderMock).setOrderDate(String.valueOf(LocalDate.now()));
		verify(sessionMock).setAttribute("order",orderMock);
		
		
	}
	
}
