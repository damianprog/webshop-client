package com.webshop.webapp.utils;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
import com.webshop.webapp.utils.SessionCartProductsCounter;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class SessionCartProductsCounterTest {

	@InjectMocks
	private SessionCartProductsCounter counter;
	
	@Mock
	private HttpSession sessionMock;
	
	@Mock
	private Cart cartMock;
	
	@Mock
	private CartProduct cartProductMock;
	
	@Test
	public void counterTest() {
		
		ArrayList<CartProduct> cartProductsList = new ArrayList<>();
		cartProductsList.add(cartProductMock);
		
		when(sessionMock.getAttribute("cart")).thenReturn(cartMock);
		when(cartMock.getCartProducts()).thenReturn(cartProductsList);
		when(cartProductMock.getQuantity()).thenReturn(1);
		
		assertEquals(counter.count(),1);
		
		verify(sessionMock).getAttribute("cart");
		verify(cartMock).getCartProducts();
		verify(cartProductMock).getQuantity();
		
	}
	
}
