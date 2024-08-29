package com.project.ETS.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ETS.enums.UserRole;
import com.project.ETS.requestDTO.RegistrationRequestDTO;
import com.project.ETS.responseDTO.UserResponse;
import com.project.ETS.service.UserService;
import com.project.ETS.utility.CustomResponseBuilder;
import com.project.ETS.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {
	
	private UserService userService;
	private CustomResponseBuilder responseBuilder;
	
	@PostMapping("/admins")
	public ResponseEntity<ResponseStructure<UserResponse>> saveAdmin(@RequestBody @Valid RegistrationRequestDTO registrationRequestDTO) {
		UserResponse response = userService.saveUser(registrationRequestDTO, UserRole.ADMIN);
		return responseBuilder.success(HttpStatus.CREATED, "Admin created", response);
	}

}
