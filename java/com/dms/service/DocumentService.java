package com.dms.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {

	Map<String, Object> saveDoument(MultipartFile file) throws Exception;
	
	Map<String, Object> getDocument(String fileID) throws Exception;

}
