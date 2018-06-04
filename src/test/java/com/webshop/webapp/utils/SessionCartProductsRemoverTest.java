package com.webshop.webapp.utils;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
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
import com.webshop.webapp.entity.Product;
import com.webshop.webapp.utils.SessionCartProductsRemover;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class SessionCartProductsRemoverTest {

	@InjectMocks
	private SessionCartProductsRemover sessionCartProductsRemover;
	
	@Mock
	private HttpSession sessionMock; 
	
	@Mock
	private Cart cartMock;
	
	@Mock
	private CartProduct cartProductMock;
	
	@Mock
	private Product productMock;
	
	private int cartProductId = 1;
	
	@Test
	public void removeTest() {
		
		ArrayList<CartProduct> cartProductsList = new ArrayList<>();
		cartProductsList.add(cartProductMock);
		
		when(sessionMock.getAttribute("cart")).thenReturn(cartMock);
		when(cartMock.getCartProducts()).thenReturn(cartProductsList);
		when(cartProductMock.getProduct()).thenReturn(productMock);
		when(productMock.getId()).thenReturn(cartProductId);

		sessionCartProductsRemover.remove(cartProductId);
		
		verify(sessionMock).getAttribute("cart");
		verify(cartMock,times(2)).getCartProducts();
		verify(cartProductMock).getProduct();
		verify(productMock).getId();

		assertTrue(!cartProductsList.contains(cartProductMock));
		
	}
	
}
