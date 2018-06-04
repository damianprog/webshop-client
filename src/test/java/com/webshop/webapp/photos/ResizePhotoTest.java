package com.webshop.webapp.photos;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

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
public class ResizePhotoTest {

	@InjectMocks
	private ResizePhoto resizePhoto;

	@Mock
	private ThumbnailsResize thumbnailsResize;

	@Mock
	private FileFactory fileFactoryMock;

	@Mock
	private InputStream inputStreamMock;

	@Mock
	private BufferedImage bufferedImageToResizeMock;

	@Mock
	private BufferedImage resizedBufferedImageMock;

	@Mock
	private ByteArrayOutputStream byteArrayOutputStreamMock;

	private byte[] bookPicBytes;

	private int width = 100, height = 100;

	@Test
	public void convertTest() throws IOException {

		when(fileFactoryMock.getByteArrayInputStream(bookPicBytes)).thenReturn(inputStreamMock);
		when(fileFactoryMock.getBufferedImage(inputStreamMock)).thenReturn(bufferedImageToResizeMock);
		when(thumbnailsResize.resize(bufferedImageToResizeMock, width, height)).thenReturn(resizedBufferedImageMock);
		when(fileFactoryMock.getByteArrayOutputStreamFromBufferedImage(resizedBufferedImageMock))
				.thenReturn(byteArrayOutputStreamMock);

		resizePhoto.resize(bookPicBytes, width, height);
		
		verify(fileFactoryMock).getByteArrayInputStream(bookPicBytes);
		verify(fileFactoryMock).getBufferedImage(inputStreamMock);
		verify(thumbnailsResize).resize(bufferedImageToResizeMock, width, height);
		verify(fileFactoryMock).getByteArrayOutputStreamFromBufferedImage(resizedBufferedImageMock);
		verify(byteArrayOutputStreamMock).toByteArray();
		
	}

}
