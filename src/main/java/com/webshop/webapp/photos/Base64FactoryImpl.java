package com.webshop.webapp.photos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Base64FactoryImpl extends Base64Factory{

	@Override
	public byte[] encode(byte[] theEncodedBase64) {
		return Base64.getEncoder().encode(theEncodedBase64);
	}

	@Override
	public String createStringFromBytes(byte[] encodeBase64) {
		return new String(encodeBase64);
	}
	
}
