package com.project.ETS.service;

import org.springframework.stereotype.Service;

import com.project.ETS.enums.UserRole;
import com.project.ETS.mapping.UserMapper;
import com.project.ETS.model.Admin;
import com.project.ETS.model.HR;
import com.project.ETS.model.Student;
import com.project.ETS.model.Trainer;
import com.project.ETS.model.User;
import com.project.ETS.repo.UserRepository;
import com.project.ETS.requestDTO.RegistrationRequestDTO;
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
	
	


}
