package com.webshop.webapp.photos;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.webshop.webapp.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class Base64EncoderTest {

	@InjectMocks
	private Base64Encoder base64Encoder;
	
	@Mock
	private Base64Factory base64Factory;
	
	private byte[] encodedBase64BytesMock;
	
	private byte[] base64ToEncodeMock;
	
	@Test
	public void encodeTest() {
		
		when(base64Factory.encode(base64ToEncodeMock)).thenReturn(encodedBase64BytesMock);
		
		base64Encoder.getEncodedImage(base64ToEncodeMock);
		
		verify(base64Factory).encode(base64ToEncodeMock);
		verify(base64Factory).createStringFromBytes(encodedBase64BytesMock);
		
	}
	
}
