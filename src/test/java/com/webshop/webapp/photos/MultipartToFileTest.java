package com.webshop.webapp.photos;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import com.webshop.webapp.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class MultipartToFileTest {

	@InjectMocks
	private MultipartToFile multipartToFileMock;
	
	@Mock
	private FileFactory fileFactory;
	
	@Mock
	private MultipartFile multipartFileMock;
	
	@Mock
	private File convFileMock;
	
	@Mock
	private FileOutputStream fileOutputStreamMock;
	
	private byte[] multipartFileBytesMock;
	
	@Test
	public void convertTest() throws IOException {
		
		when(fileFactory.multipartFileGetOriginalFileName(multipartFileMock)).thenReturn(convFileMock);
		when(fileFactory.createFileOutputStream(convFileMock)).thenReturn(fileOutputStreamMock);
		when(multipartFileMock.getBytes()).thenReturn(multipartFileBytesMock);
		
		multipartToFileMock.convert(multipartFileMock);
		
		verify(fileFactory).multipartFileGetOriginalFileName(multipartFileMock);
		verify(convFileMock).createNewFile();
		verify(fileFactory).createFileOutputStream(convFileMock);
		verify(fileOutputStreamMock).write(multipartFileBytesMock);
		verify(fileOutputStreamMock).close();
		verify(multipartFileMock).getBytes();
		
	}
	
}
