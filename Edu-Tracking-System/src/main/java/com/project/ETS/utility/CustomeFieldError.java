package com.project.ETS.utility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomeFieldError {
	
	private String fieldName;
	private String errorMessage;
	
	public static CustomeFieldError create(String fieldName,String errorMessage) {
		CustomeFieldError customFieldError=new CustomeFieldError();
		customFieldError.setFieldName(fieldName);
		customFieldError.setErrorMessage(errorMessage);
		return customFieldError;
	}

}
