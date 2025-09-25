package com.dms.dao.repository.entity;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "documents")
@Data
public class Folder {
	
	@Id
	private String id;
	private SubFolder subFolder;
	private FileEntity documents;
}
