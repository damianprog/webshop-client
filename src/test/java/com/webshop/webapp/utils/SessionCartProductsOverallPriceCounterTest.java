package com.webshop.webapp.utils;

import static org.junit.Assert.assertEquals;
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
import com.webshop.webapp.utils.SessionCartProductsOverallPriceCounter;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class SessionCartProductsOverallPriceCounterTest {

	@InjectMocks
	private SessionCartProductsOverallPriceCounter sessionCartProductsOverallPriceCounter;
	
	@Mock
	private HttpSession sessionMock;
	
	@Mock
	private Cart cartMock;
	
	@Mock
	private CartProduct cartProductMock;
	
	private double cartProductMockPrice = 1;
	
	@Test
	public void countcountOverallValueEmptyTest() {
		
		ArrayList<CartProduct> cartProducts = new ArrayList<>();
		
		when(sessionMock.getAttribute("cart")).thenReturn(cartMock);
		when(cartMock.getCartProducts()).thenReturn(cartProducts);
		
		assertEquals(sessionCartProductsOverallPriceCounter.countOverallValue(),0,0);
		
	}
	
	@Test
	public void countcountOverallValueTest() {
		
		ArrayList<CartProduct> cartProductsList = new ArrayList<>();
		cartProductsList.add(cartProductMock);
		
		when(sessionMock.getAttribute("cart")).thenReturn(cartMock);
		when(cartMock.getCartProducts()).thenReturn(cartProductsList);
		when(cartProductMock.getPrice()).thenReturn(cartProductMockPrice);
		
		assertEquals(sessionCartProductsOverallPriceCounter.countOverallValue(),cartProductMockPrice,0);
		
	}
	
}
