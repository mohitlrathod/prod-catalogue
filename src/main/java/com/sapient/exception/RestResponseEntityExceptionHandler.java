package com.sapient.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends BaseExceptionHandler  {

	public RestResponseEntityExceptionHandler() {
		registerMapping(NotFoundException.class, "Not found", HttpStatus.NOT_FOUND);
		registerMapping(EntityCreateException.class, "Failed To Create", HttpStatus.BAD_REQUEST);
		registerMapping(EmptyResultDataAccessException.class, "Not found", HttpStatus.NOT_FOUND);
	}
}