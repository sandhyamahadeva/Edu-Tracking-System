package com.project.ETS.requestDTO;

import com.project.ETS.enums.UserRole;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserRequest {
	
	@NotNull(message = "Username cannot be null")
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9#$&*-_.!@]*$")
	private String username;
	
	@NotNull(message = "email cannot be null")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$")
	private String email;
	
	
	@NotNull(message = "password cannot be null")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$^&*.\\-_])[A-Za-z\\d!@#$^&*.\\-_]{8,}$")
	private String password;
	
	
	@NotNull(message =  "role cannot be null")
	private UserRole role;
	
	

}
