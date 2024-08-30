package com.project.ETS.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.ETS.enums.Stack;
import com.project.ETS.enums.UserRole;
import com.project.ETS.requestDTO.StudentRequest;
import com.project.ETS.requestDTO.TrainerRequest;
import com.project.ETS.responseDTO.StudentResponse;
import com.project.ETS.responseDTO.TrainerResponse;
import com.project.ETS.responseDTO.UserResponse;
import com.project.ETS.security.RegistrationRequestDTO;
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
	public ResponseEntity<ResponseStructure<UserResponse>> saveAdmin(@Valid @RequestBody  RegistrationRequestDTO registrationRequestDTO) {
		UserResponse response = userService.saveUser(registrationRequestDTO, UserRole.ADMIN);
		return responseBuilder.success(HttpStatus.CREATED, "Admin created", response);
	}
	
	@PostMapping("/trainers")
	public ResponseEntity<ResponseStructure<UserResponse>> saveTrainer(@RequestBody@Valid RegistrationRequestDTO registrationRequestDTO) {
		UserResponse response = userService.saveUser(registrationRequestDTO, UserRole.TRAINER);
		return responseBuilder.success(HttpStatus.CREATED, "Trainer created", response);
	}
	
	@PostMapping("/hrs")
	public ResponseEntity<ResponseStructure<UserResponse>> saveHR(@RequestBody@Valid RegistrationRequestDTO registrationRequestDTO) {
		UserResponse response = userService.saveUser(registrationRequestDTO, UserRole.HR);
		return responseBuilder.success(HttpStatus.CREATED, "HR created", response);
	}
	
	@PostMapping("/students")
	public ResponseEntity<ResponseStructure<UserResponse>> saveStudent(@RequestBody@Valid RegistrationRequestDTO registrationRequestDTO) {
		UserResponse response = userService.saveUser(registrationRequestDTO, UserRole.STUDENT);
		return responseBuilder.success(HttpStatus.CREATED, "Student created", response);
	}
	
	@PutMapping("/trainers/{trainerId}")
	public ResponseEntity<ResponseStructure<TrainerResponse>> updateTrainer(@RequestBody @Valid TrainerRequest trainerRequestDTO, @PathVariable String trainerId){
		TrainerResponse trainerResponseDTO = (TrainerResponse) userService.updateUser(trainerRequestDTO, trainerId, UserRole.TRAINER);
		return responseBuilder.success(HttpStatus.OK, "Trainer updated", trainerResponseDTO);
	}
	
	@PutMapping("/students/{userId}")
	public ResponseEntity<ResponseStructure<StudentResponse>> updateStudent(@RequestBody StudentRequest studentRequest,@PathVariable String userId){
		StudentResponse studentResponse= (StudentResponse) userService.updateUser(studentRequest,userId,UserRole.STUDENT);
		return responseBuilder.success(HttpStatus.OK, "Student Updated", studentResponse);
	}
	
	@PatchMapping("/students/{userId}")
	public ResponseEntity<ResponseStructure<StudentResponse>> updateStudentStack(@RequestParam Stack stack,@PathVariable String userId){
		StudentResponse response=userService.updateStudent(stack, userId);
		return responseBuilder.success(HttpStatus.OK, "Student stack is Updated", response);
	}

}
