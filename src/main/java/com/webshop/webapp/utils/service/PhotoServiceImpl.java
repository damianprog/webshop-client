package com.webshop.webapp.utils.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.webshop.webapp.photos.Base64Encoder;
import com.webshop.webapp.photos.MultipartImageConverter;
import com.webshop.webapp.photos.MultipartToFile;
import com.webshop.webapp.photos.ResizePhoto;

@Service
public class PhotoServiceImpl implements PhotoService {

	@Autowired
	private Base64Encoder base64Encoder;

	@Autowired
	private MultipartImageConverter multipartImageConverter;

	@Autowired
	private MultipartToFile multipartToFile;

	@Autowired
	private ResizePhoto resizePhoto;

	@Override
	public String getEncodedImage(byte[] theEncodedBase64) {

		return base64Encoder.getEncodedImage(theEncodedBase64);
	}

	@Override
	public byte[] convertMultipartImage(MultipartFile mf, int width, int height) throws IOException {

		return multipartImageConverter.convert(mf, width, height);

	}

	@Override
	public File convertMultipartToFile(MultipartFile file) throws IOException {

		return multipartToFile.convert(file);
	}

	@Override
	public byte[] resize(byte[] productPicBytes, int width, int height) throws IOException {

		return resizePhoto.resize(productPicBytes, width, height);
	}

}
