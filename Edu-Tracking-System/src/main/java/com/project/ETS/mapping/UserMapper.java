package com.project.ETS.mapping;

import org.springframework.stereotype.Component;

import com.project.ETS.model.User;
import com.project.ETS.requestDTO.RegistrationRequestDTO;
import com.project.ETS.responseDTO.UserResponse;

@Component
public class UserMapper {
	
	public User mapToUserEntity(RegistrationRequestDTO registrationRequestDTO, User user) {
		user.setUsername(registrationRequestDTO.getUsername());
		user.setEmail(registrationRequestDTO.getEmail());
		user.setPassword(registrationRequestDTO.getPassword());
		return user;
	}
	
	
	public UserResponse mapToUserResponse(User user) {
		UserResponse response = new UserResponse();
		response.setUserId(user.getUserId());
		response.setEmail(user.getEmail());
		response.setUsername(user.getUsername());
		return response;
	}

}
