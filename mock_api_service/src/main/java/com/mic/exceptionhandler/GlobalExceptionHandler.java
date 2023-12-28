package com.mic.exceptionhandler;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {


	
		@ExceptionHandler(ConstraintViolationException.class)
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<?> constraintViolationException(ConstraintViolationException ex) {

		Map<String, String> errors = new HashMap<>();
		ex.getConstraintViolations().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getMessage();
			errors.put(fieldName, errorMessage);
		});

		ErrorMessageDetails errorDetails = ErrorMessageDetails.builder().timestamp(LocalDateTime.now())
				.message("Validation Exception").details("").errors(errors).build();

		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
		
		
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException ex) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		ErrorMessageDetails errorDetails = ErrorMessageDetails.builder().timestamp(LocalDateTime.now())
				.message("Validation Exception").details("").errors(errors).build();

		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
//		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
//		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
}
