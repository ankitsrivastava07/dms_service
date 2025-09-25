package com.dms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.dms.service.DocumentService;

@RestController
@RequestMapping("/api/v1/document")
public class DocumentController {

	@Autowired
	private DocumentService documentService;

	@PostMapping
	public ResponseEntity<Map<String, Object>> saveDocuments(@RequestParam("file") MultipartFile file)
			throws Exception {
		Map<String, Object> response = documentService.saveDoument(file);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/{fileId}")
	public ResponseEntity<?> downloadPdfFile(@PathVariable String fileId) throws Exception {

		Map<String, Object> payLoad = documentService.getDocument(fileId);

		// Set response headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentDispositionFormData("attachment", payLoad.get("fileName").toString());

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(payLoad.get("content"));
	}

}
