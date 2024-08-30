package com.project.ETS.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.ETS.exception.UserNotFoundByIdException;
import com.project.ETS.utility.CustomResponseBuilder;
import com.project.ETS.utility.ErrorStructure;

import lombok.AllArgsConstructor;

@RestControllerAdvice
@AllArgsConstructor
public class UserExceptionHandler  {
	private CustomResponseBuilder responseBuilder;
	
	public ResponseEntity<ErrorStructure<String>> handleUserNotFoundById(UserNotFoundByIdException exception){
		return responseBuilder.error(HttpStatus.NOT_FOUND,exception.getMessage(),"user not found by given id");
	}

}
