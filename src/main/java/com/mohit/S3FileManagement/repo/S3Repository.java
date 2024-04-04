package com.mohit.S3FileManagement.repo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;

import software.amazon.ion.Timestamp;

@Repository
public class S3Repository {
	
	@Autowired
	private AmazonS3 amazonS3;
	
	public String uploadFile(MultipartFile file) {
		
		amazonS3.putObject("javahandson-bucket",file.getOriginalFilename(), convertFile(file));
		return "File Uploaded in S3 bucket : "+ file.getOriginalFilename();
	}
	
	private File convertFile(MultipartFile file) {
		File conFile=new File(file.getOriginalFilename());
		try (FileOutputStream os = new FileOutputStream(conFile)) {
		    os.write(file.getBytes());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return conFile;
	}
	
	
	public String deletFile(String filename) {
		amazonS3.deleteObject("javahandson-bucket", filename);
		return "File has been deleted :"+ filename;
	}
	

}
