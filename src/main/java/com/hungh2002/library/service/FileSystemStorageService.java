package com.hungh2002.library.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileSystemStorageService implements StorageService {

	public String resourcePath = "src/main/resources/static/";


    @Override
    public String storeFile(MultipartFile file, Long fileNameWithoutExtension, String dir) {

		String fileExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());
		String fileName = fileNameWithoutExtension + "." + fileExtension;
		Path destinationFile = Paths.get( resourcePath + dir + fileName);

		try (InputStream inputStream = file.getInputStream()) {
			Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
		}

		catch (IOException e) {
			e.printStackTrace();
		}
		return dir + fileName;
    }

	public void deleteFile (String pathFile){

		Path path = Paths.get(resourcePath + pathFile);
		try {
			Files.delete(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
