package com.order.project.errorhandling;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolation(final ConstraintViolationException ex) {
		
		ApiError apiError = new ApiError(HttpStatus.UNPROCESSABLE_ENTITY, ex.getErrorMessage());
		return new ResponseEntity<>(apiError, apiError.getHttpStatus());
	}
	
	@ExceptionHandler({ ResourceNotFoundException.class })
	public ResponseEntity<Object> handleResourceNotFoundException(final ResourceNotFoundException ex) {
		
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
		return new ResponseEntity<>(apiError, apiError.getHttpStatus());
	}
}
