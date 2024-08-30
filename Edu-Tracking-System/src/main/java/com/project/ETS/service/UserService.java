package com.project.ETS.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.ETS.enums.Stack;
import com.project.ETS.enums.UserRole;
import com.project.ETS.mapping.UserMapper;
import com.project.ETS.model.Admin;
import com.project.ETS.model.HR;
import com.project.ETS.model.Student;
import com.project.ETS.model.Trainer;
import com.project.ETS.model.User;
import com.project.ETS.repo.UserRepository;
import com.project.ETS.requestDTO.RegistrationRequestDTO;
import com.project.ETS.requestDTO.StudentRequest;
import com.project.ETS.requestDTO.TrainerRequest;
import com.project.ETS.requestDTO.UserRequest;
import com.project.ETS.responseDTO.StudentResponse;
import com.project.ETS.responseDTO.UserResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	
	private UserMapper userMapper;
	private UserRepository userRepo;
	
	public  UserResponse saveUser(RegistrationRequestDTO registrationRequestDTO, UserRole role) {
		
		User user = null;
		
		switch(role) {
		case ADMIN -> user= new Admin();
		case HR -> user = new HR();
		case TRAINER -> user = new Trainer();
		case STUDENT -> user =  new Student();
		
		default -> throw new IllegalArgumentException("Unexpected value: "+role);
		}
		
		if(user != null) {
			user = userMapper.mapToUserEntity(registrationRequestDTO, user);
			user.setRole(role);
			user = userRepo.save(user);
		}
		
		return userMapper.mapToUserResponse(user);
		
		
	}
	
	public UserResponse updateUser(UserRequest userRequestDTO, String userId,UserRole role) {
		Optional<User> optional = userRepo.findById(userId);
		User user = optional.get();
		
		if(user!=null) {
			
		switch (role) {
		
		
		
		case TRAINER:{
			Trainer trainer = (Trainer) user;
			TrainerRequest trainerRequestDTO = (TrainerRequest)userRequestDTO;
			trainer = userMapper.mapToTrainerEntity(trainerRequestDTO,trainer);
			trainer = userRepo.save(trainer);
			
			return userMapper.mapToTrainerResponse(trainer);
		}
		
		case STUDENT:{
			Student student = (Student) user;
			StudentRequest studentRequestDTO = (StudentRequest)userRequestDTO;
			student = userMapper.mapToStudentEntity(studentRequestDTO, student);
			student = userRepo.save(student);
			
			return userMapper.mapToStudentResponse(student);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + role);
		}
	}
		return null;
	}
	
	
	


}
