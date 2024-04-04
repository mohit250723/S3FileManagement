package com.mohit.S3FileManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mohit.S3FileManagement.repo.S3Repository;

@RestController
@RequestMapping("/s3")
public class S3Controller {
	
	@Autowired
	private S3Repository repository;
	
	@PostMapping("/upload")
	public String uploadFile(@RequestParam  MultipartFile file){
		return repository.uploadFile(file);
	}

	@DeleteMapping("/deleteFile/{filename}")
	public String deletFile(@PathVariable String filename) {
		return repository.deletFile(filename);
	}
}
