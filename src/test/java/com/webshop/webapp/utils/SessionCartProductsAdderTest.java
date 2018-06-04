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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.webshop.webapp.Application;
import com.webshop.webapp.entity.Cart;
import com.webshop.webapp.entity.CartProduct;
import com.webshop.webapp.entity.Product;
import com.webshop.webapp.entity.service.ProductService;
import com.webshop.webapp.factories.CartProductFactory;
import com.webshop.webapp.utils.SessionCartProductsAdder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class SessionCartProductsAdderTest {

	@InjectMocks
	private SessionCartProductsAdder sessionCartProductsAdder;
	
	@Mock
	private HttpSession sessionMock;

	@Mock
	private ProductService productServiceMock;
	
	@Mock
	private Cart cartMock;
	
	@Mock
	private CartProduct cartProductMock;
	
	@Mock
	private CartProduct newCartProductMock;
	
	@Mock
	private Product productMock;
	
	@Mock
	private CartProductFactory cartProductFactoryMock;
	
	private int productMockId = 1;
	
	private int cartProductMockQuantity = 2;
	
	private int productMockQuantity = 1;
	
	@Test
	public void addContainsTrueTest() {
		
		ArrayList<CartProduct> cartProducts = new ArrayList<>();
		cartProducts.add(cartProductMock);
		
		when(sessionMock.getAttribute("cart")).thenReturn(cartMock);
		when(cartMock.getCartProducts()).thenReturn(cartProducts);
		when(cartProductMock.getProduct()).thenReturn(productMock);
		when(productMock.getId()).thenReturn(productMockId);
		when(cartProductMock.getQuantity()).thenReturn(cartProductMockQuantity);
		
		sessionCartProductsAdder.add(productMockId, productMockQuantity);
		
		verify(sessionMock).getAttribute("cart");
		verify(cartMock).getCartProducts();
		verify(cartProductMock).getProduct();
		verify(productMock).getId();
		verify(cartProductMock).getQuantity();
		verify(cartProductMock).setQuantity(cartProductMockQuantity + productMockQuantity);
		
	}
	
	@Test
	public void addContainsFalseTest() {
		
		ArrayList<CartProduct> cartProducts = new ArrayList<>();
		cartProducts.add(cartProductMock);
		
		when(sessionMock.getAttribute("cart")).thenReturn(cartMock);
		when(cartMock.getCartProducts()).thenReturn(cartProducts);
		when(cartProductMock.getProduct()).thenReturn(productMock);
		when(productMock.getId()).thenReturn(productMockQuantity + 1);
		
		when(cartProductFactoryMock.createInstance()).thenReturn(newCartProductMock);
		when(productServiceMock.getProductById(productMockId)).thenReturn(productMock);
		
		sessionCartProductsAdder.add(productMockId, productMockQuantity);
		
		verify(sessionMock).getAttribute("cart");
		verify(cartMock,times(2)).getCartProducts();
		verify(cartProductMock).getProduct();
		verify(productMock).getId();
		
		verify(cartProductFactoryMock).createInstance();
		verify(productServiceMock).getProductById(productMockId);
		verify(newCartProductMock).setProduct(productMock);
		verify(newCartProductMock).setQuantity(productMockQuantity);
		
		assertTrue(cartProducts.contains(newCartProductMock));
		
	}
	
}
