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
import com.webshop.webapp.entity.Product;
import com.webshop.webapp.utils.ProductsPhotosInitializer;
import com.webshop.webapp.utils.service.PhotoService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class ProductsPhotosInitializerTest {

	@InjectMocks
	private ProductsPhotosInitializer productsPhotosInitializer;

	@Mock
	private PhotoService photoService;

	@Mock
	private Product productMock;

	private byte[] productPhoto;

	private byte[] resizedProductPhoto;

	private String encodedProductPhoto;

	private int width = 200,height = 200;
	
	@Test
	public void initializeTest() throws IOException {

		List<Product> products = new ArrayList<>();
		products.add(productMock);

		when(productMock.getProductPhoto()).thenReturn(productPhoto);
		when(photoService.resize(productPhoto, width, height)).thenReturn(resizedProductPhoto);
		when(photoService.getEncodedImage(resizedProductPhoto)).thenReturn(encodedProductPhoto);

		productsPhotosInitializer.initialize(products);

		verify(productMock).getProductPhoto();
		verify(photoService).resize(productPhoto, width, height);
		verify(photoService).getEncodedImage(resizedProductPhoto);
		verify(productMock).setEncodedProductPhoto(encodedProductPhoto);

	}

}
