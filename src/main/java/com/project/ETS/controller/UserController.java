package com.project.ETS.controller;

import com.project.ETS.responseDTO.RatingResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.ETS.enums.Stack;
import com.project.ETS.enums.UserRole;
import com.project.ETS.requestDTO.StudentRequest;
import com.project.ETS.requestDTO.TrainerRequest;
import com.project.ETS.responseDTO.StudentResponse;
import com.project.ETS.responseDTO.TrainerResponse;
import com.project.ETS.responseDTO.UserResponse;
import com.project.ETS.security.RegistrationRequestDTO;
import com.project.ETS.service.UserService;
import com.project.ETS.utility.AppResponseBuilder;
import com.project.ETS.utility.ResponseStructure;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

	private UserService userService;
	private AppResponseBuilder responseBuilder;



	@Operation(description = "The API endpoint is used to register the admins",
			responses = {
					@ApiResponse(responseCode = "201", description = "Admin created"),
					@ApiResponse(responseCode = "500", description = "Internal Sever Error",
							content = {
									@Content(schema = @Schema(anyOf = RuntimeException.class))
							})
			})
	@PostMapping("/admins/register")
	public ResponseEntity<ResponseStructure<UserResponse>> saveAdmin(
			@org.springframework.web.bind.annotation.RequestBody @Valid RegistrationRequestDTO registerationRequestDTO) {
		UserResponse response = userService.saveUser(registerationRequestDTO, UserRole.ADMIN);
		return responseBuilder.success(HttpStatus.CREATED, "admin successfully created", response);
	}

	@Operation(description = "The API endpoint is used to register the Hrs",
			responses = {
					@ApiResponse(responseCode = "201",description = "HR created"),
					@ApiResponse(responseCode = "500",description = "Internal Server Error",
							content = {
									@Content(schema = @Schema(anyOf = RuntimeException.class))
							})
			})
	@PostMapping("/hrs/register")
	public ResponseEntity<ResponseStructure<UserResponse>> saveHR(
			@org.springframework.web.bind.annotation.RequestBody @Valid RegistrationRequestDTO registerationRequestDTO) {
		UserResponse response = userService.saveUser(registerationRequestDTO, UserRole.HR);
		return responseBuilder.success(HttpStatus.CREATED, "HR Created", response);
	}

	@Operation(description = "The API endpoint is used to register the trainers",
			responses = {
					@ApiResponse(responseCode = "201",description = "Trainer created"),
					@ApiResponse(responseCode = "500",description = "Internal server Error",
							content = {
									@Content(schema = @Schema(anyOf = RuntimeException.class))
							})
			})
	@PostMapping("/trainers/register")
	public ResponseEntity<ResponseStructure<UserResponse>> saveTrainer(
			@org.springframework.web.bind.annotation.RequestBody @Valid RegistrationRequestDTO registerationRequestDTO) {
		UserResponse response = userService.saveUser(registerationRequestDTO, UserRole.TRAINER);
		return responseBuilder.success(HttpStatus.CREATED, "Trainer created", response);
	}

	@Operation(description = "The API endpoint is used to register the students",
			responses = {
					@ApiResponse(responseCode = "201", description = "Student created"),
					@ApiResponse(responseCode = "501", description = "Internal server error",
							content = {
									@Content(schema = @Schema(anyOf = RuntimeException.class))
							})
			})
	@PostMapping("/students/register")
	public ResponseEntity<ResponseStructure<UserResponse>> saveStudent(
			@org.springframework.web.bind.annotation.RequestBody @Valid RegistrationRequestDTO registerationRequestDTO) {
		UserResponse response = userService.saveUser(registerationRequestDTO, UserRole.STUDENT);
		return responseBuilder.success(HttpStatus.CREATED, "student created", response);
	}

	@Operation(description = "The API endpoint is used to update the student",responses = {
			@ApiResponse(responseCode = "200",description = "Student updated"),
			@ApiResponse(responseCode = "501",description = "Internal server error",
					content = {
							@Content(schema = @Schema(anyOf = RuntimeException.class))
					})
	})
	@PutMapping("/users/students/{userId}")
	public ResponseEntity<ResponseStructure<StudentResponse>> updateStudent(@PathVariable String userId,
																			   @org.springframework.web.bind.annotation.RequestBody StudentRequest studentRequest) {
		StudentResponse studentResponse = userService.updateStudent(studentRequest, userId);
		return responseBuilder.success(HttpStatus.OK, "student updated successfully", studentResponse);
	}

	@Operation(description = "The API endpoint is used to update the student",responses = {
			@ApiResponse(responseCode = "200",description = "student stack updated"),
			@ApiResponse(responseCode = "501",description = "Internal server error",
					content = {
							@Content(schema = @Schema(anyOf = RuntimeException.class))
					})

	})
	@PatchMapping("/users/students/{userId}")
	public ResponseEntity<ResponseStructure<StudentResponse>> updateStudentStack(@RequestParam Stack stack,
																					@PathVariable String userId) {
		StudentResponse response = userService.updateStudent(stack, userId);
		return responseBuilder.success(HttpStatus.OK, "student stack is updated", response);
	}

	@Operation(description = "The API endpoint is used to update trainer",responses = {
			@ApiResponse(responseCode = "200",description = "trainer is updated"),
			@ApiResponse(responseCode = "501",description = "Internal server error",
					content = {
							@Content(schema = @Schema(anyOf = RuntimeException.class))
					})
	})
	@PutMapping("/users/trainers/{userId}")
	public ResponseEntity<ResponseStructure<UserResponse>> updateTrainer(@RequestBody TrainerRequest trainerRequest,
																		 @PathVariable String userId) {
		UserResponse response = userService.updateTrainer(trainerRequest, userId);
		return responseBuilder.success(HttpStatus.OK, "Trainer updated", response);
	}

	@Operation(description = "The API endpoint is used to view ratings",responses = {
			@ApiResponse(responseCode = "302",description = "raings found"),
			@ApiResponse(responseCode = "500",description = "Internal server error",
					content = {
							@Content(schema = @Schema(anyOf = RuntimeException.class))
					})
	})
	@GetMapping("/students/{studentId}/ratings")
	public ResponseEntity<ResponseStructure<List<RatingResponse>>> viewRating(@PathVariable String studentId) {
		List<RatingResponse> responses = userService.viewRating(studentId);
		return responseBuilder.success(HttpStatus.FOUND, "found the ratings of the student", responses);
	}

}
