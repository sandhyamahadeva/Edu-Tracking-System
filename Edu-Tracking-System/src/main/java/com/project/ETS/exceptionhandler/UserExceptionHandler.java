package com.project.ETS.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.ETS.exception.UserNotFoundByIdException;
import com.project.ETS.utility.AppResponseBuilder;
import com.project.ETS.utility.ErrorStructure;

import lombok.AllArgsConstructor;

@RestControllerAdvice
@AllArgsConstructor
public class UserExceptionHandler  {
	private AppResponseBuilder builder;

	@ExceptionHandler(UserNotFoundByIdException.class)
	public ResponseEntity<ErrorStructure<String>> handleUserNotFoundById(UserNotFoundByIdException exception){
		return builder.error(HttpStatus.NOT_FOUND, exception.getMessage(), "user not found by given id");
	}
}
