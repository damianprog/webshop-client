package com.webshop.webapp.utils;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
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
import com.webshop.webapp.entity.CartProduct;
import com.webshop.webapp.entity.Product;
import com.webshop.webapp.utils.CartProductsPhotosInitializer;
import com.webshop.webapp.utils.service.PhotoService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class CartProductsPhotosInitializerTest {

	@InjectMocks
	private CartProductsPhotosInitializer cartProductsPhotosInitializer;
	
	@Mock
	private PhotoService photoServiceMock;
	
	@Mock
	private CartProduct cartProductMock;
	
	@Mock
	private Product productMock;
	
	private byte[] productPhoto; 
	
	private byte[] resizedProductPhoto; 
	
	private String encodedImage;
	
	private int width=100,height = 100;
	
	@Test
	public void initializeTest() throws IOException {
		
		List<CartProduct> cpList = new ArrayList<>();
		cpList.add(cartProductMock);
		
		when(cartProductMock.getProduct()).thenReturn(productMock);
		when(productMock.getProductPhoto()).thenReturn(productPhoto);
		when(photoServiceMock.resize(productPhoto,width,height)).thenReturn(resizedProductPhoto);
		when(photoServiceMock.getEncodedImage(resizedProductPhoto)).thenReturn(encodedImage);
		
		cartProductsPhotosInitializer.initialize(cpList,width,height);
		
		verify(cartProductMock).getProduct();
		verify(productMock).getProductPhoto();
		verify(photoServiceMock).resize(productPhoto,width,height);
		verify(photoServiceMock).getEncodedImage(resizedProductPhoto);
		
	}
	
}
