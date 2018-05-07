package com.webshop.webapp.utils.service;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface PhotoService {

	public String getEncodedImage(byte[] theEncodedBase64);

	public byte[] convertMultipartImage(MultipartFile mf, int width, int height) throws IOException;

	public File convertMultipartToFile(MultipartFile file) throws IOException;

	public byte[] resize(byte[] bookPicBytes, int width, int height) throws IOException;

}
