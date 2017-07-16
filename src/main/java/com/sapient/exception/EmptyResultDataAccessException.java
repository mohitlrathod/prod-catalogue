package com.sapient.exception;

public class EmptyResultDataAccessException extends Exception {
private static final long serialVersionUID = 1L;
	
	public EmptyResultDataAccessException(String message){
		super(message);
	}

}
