package com.webshop.webapp.photos;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class MultipartImageConverter {

	@Autowired
	private MultipartToFile multipartToFile;

	@Autowired
	private ResizePhoto resizePhoto;
	
	@Autowired
	private FileFactory fileFactory;

	public byte[] convert(MultipartFile mf, int width, int height) throws IOException {

		File convFile = multipartToFile.convert(mf);

		byte[] convFileBytes = fileFactory.fileToBytes(convFile);
		
		return resizePhoto.resize(convFileBytes, width, height);

	}

}
