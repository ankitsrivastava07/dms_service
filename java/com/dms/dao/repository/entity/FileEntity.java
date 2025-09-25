package com.dms.dao.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class FileEntity {

	@Id
	private String id;
	private String documentName;
	private String _contentType;
	private long size;
	private byte content[];
}
