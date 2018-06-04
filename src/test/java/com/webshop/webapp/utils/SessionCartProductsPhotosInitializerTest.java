package com.webshop.webapp.utils;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
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
import com.webshop.webapp.utils.SessionCartProductsPhotosInitializer;
import com.webshop.webapp.utils.service.PhotoService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class SessionCartProductsPhotosInitializerTest {

	@InjectMocks
	private SessionCartProductsPhotosInitializer sessionCartProductsPhotosInitializer;
	
	@Mock
	private PhotoService photoServiceMock;
	
	@Mock
	private HttpSession sessionMock;
	
	@Mock
	private Cart cartMock;
	
	@Mock
	private CartProduct cartProductMock;
	
	@Mock
	private Product productMock;
	
	private byte[] productPhoto;
	
	private byte[] resizedProductPhoto;
	
	private String encodedProductPhoto;
	
	private int width=100,height = 100;
	
	@Test
	public void initializeTest() throws IOException {
		
		ArrayList<CartProduct> cartProductsList = new ArrayList<>();
		cartProductsList.add(cartProductMock);
		
		when(sessionMock.getAttribute("cart")).thenReturn(cartMock);
		when(cartMock.getCartProducts()).thenReturn(cartProductsList);
		when(cartProductMock.getProduct()).thenReturn(productMock);
		
		when(productMock.getProductPhoto()).thenReturn(productPhoto);
		when(photoServiceMock.resize(productPhoto,width,height)).thenReturn(resizedProductPhoto);
		when(photoServiceMock.getEncodedImage(resizedProductPhoto)).thenReturn(encodedProductPhoto);
		
		sessionCartProductsPhotosInitializer.initialize();
		
		verify(sessionMock).getAttribute("cart");
		verify(cartProductMock).getProduct();
		verify(productMock).getProductPhoto();
		verify(photoServiceMock).resize(productPhoto,width,height);
		verify(photoServiceMock).getEncodedImage(resizedProductPhoto);
		verify(productMock).setEncodedProductPhoto(encodedProductPhoto);
		
		
	}
	
}
