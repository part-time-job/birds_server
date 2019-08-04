package com.ue.utils;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {
	public static boolean storeFile(String path, MultipartFile file){
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			fileOutputStream.write(file.getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
