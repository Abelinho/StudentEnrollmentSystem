package com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.abel.StudentEnrollmentSystem.StudentEnrollmentSystem.Entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ErrorMessage> StudentNotFoundException(StudentNotFoundException exception, WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				             .body(message);
	}
	//Web request isnt being used
	//this shd catch ill arg exceptions
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorMessage> IllegalArgumentException(IllegalArgumentException exception, WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				             .body(message);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> AgeRangeException(Exception exception, WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				             .body(message);
	}
	
}
