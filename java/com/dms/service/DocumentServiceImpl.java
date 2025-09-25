package com.dms.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dms.dao.repository.entity.FileEntity;
import com.mongodb.client.gridfs.model.GridFSFile;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private GridFsTemplate gridFTemplate;

	@Autowired
	private GridFsOperations gridFsOperations;

	@Override
	public Map<String, Object> saveDoument(MultipartFile file) throws IOException {
		Map<String, Object> response = new HashMap<>();

		FileEntity fileEntity = new FileEntity();
		String fileName = file.getOriginalFilename();
		String contentType = file.getContentType();

		fileEntity.setSize(file.getSize());
		fileEntity.setDocumentName(fileName);
		fileEntity.setContent(file.getBytes());
		fileEntity.set_contentType(contentType);
		InputStream inputStream = file.getInputStream();
		String objId = gridFTemplate.store(inputStream, fileName, fileEntity).toString();

		response.put("msg", "File Uploaded successfully");
		response.put("flag", "Success");
		response.put("fileId", objId);
		return response;
	}

	@Override
	public Map<String, Object> getDocument(String fileID) throws Exception {
		Map<String, Object> fileData = new HashMap<>();
		Query query = new Query(Criteria.where("_id").is(fileID));
		GridFSFile gridsFile = gridFsOperations.findOne(query);

		GridFsResource gridResource = gridFsOperations.getResource(gridsFile);
		byte[] content = gridResource.getInputStream().readAllBytes();

		String fileName = gridResource.getFilename();
		String contentType = gridResource.getContentType();
		fileData.put("fileName", fileName);
		fileData.put("contentType", contentType);
		fileData.put("content", content);

		return fileData;
	}

}
