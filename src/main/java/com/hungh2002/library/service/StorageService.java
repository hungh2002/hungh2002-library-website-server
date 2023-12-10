package com.hungh2002.library.service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
	
	String storeFile (MultipartFile file, Long fileNameWithoutExtension, String dir);

	void deleteFile (String pathFile);
}
