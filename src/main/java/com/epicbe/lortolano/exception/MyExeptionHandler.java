package com.epicbe.lortolano.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import jakarta.persistence.EntityExistsException;

@ControllerAdvice
public class MyExeptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(EntityExistsException.class)
	ResponseEntity<String> manageEntityExeption(EntityExistsException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
	}
	
}
