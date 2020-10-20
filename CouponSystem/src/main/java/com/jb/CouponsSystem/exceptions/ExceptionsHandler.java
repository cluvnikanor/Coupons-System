package com.jb.CouponsSystem.exceptions;

import java.rmi.ServerException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {
	@ExceptionHandler(value = { Exception.class, ServerException.class })
	// When Exception is thrown on the server, a response sends to client - that
	// contains the error message from the Exceptions.
	public ResponseEntity<?> handleExceptions(Exception e) {
		return new ResponseEntity<>(new ErrorMessage(new Date(), e.getMessage()), HttpStatus.BAD_REQUEST);
	}
}
