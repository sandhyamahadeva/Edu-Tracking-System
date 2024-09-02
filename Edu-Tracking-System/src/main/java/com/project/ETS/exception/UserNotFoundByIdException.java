package com.project.ETS.exception;

import lombok.AllArgsConstructor;

@SuppressWarnings("serial")
@AllArgsConstructor
public class UserNotFoundByIdException extends RuntimeException{

	private String message;

	@Override
	public String getMessage() {
		return message;
	}

}
