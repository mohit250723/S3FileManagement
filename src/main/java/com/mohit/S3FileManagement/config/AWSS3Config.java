package com.mohit.S3FileManagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;

import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AWSS3Config {
	
	@Bean
	public AmazonS3 amazonS3() {
		return  AmazonS3ClientBuilder.standard().withRegion("SPECIFY_S3_REGION").
		withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("SPCIFY_ACCESS_KEY", "SPECIFY_SECRET_KEY"))).build();
	}
}
