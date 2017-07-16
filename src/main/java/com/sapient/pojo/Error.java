package com.sapient.pojo;

import org.springframework.http.HttpStatus;


public class Error {

	
	private final String message;
	private final HttpStatus status;
	
	
	
	
	public Error(String message, HttpStatus status) {
		super();
		this.message = message;
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	
	
	
	
	
}
