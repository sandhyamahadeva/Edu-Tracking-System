package com.project.ETS.mapping;

import org.springframework.stereotype.Component;

import com.project.ETS.model.Student;
import com.project.ETS.model.Trainer;
import com.project.ETS.model.User;
import com.project.ETS.requestDTO.RegistrationRequestDTO;
import com.project.ETS.requestDTO.StudentRequest;
import com.project.ETS.requestDTO.TrainerRequest;
import com.project.ETS.responseDTO.StudentResponse;
import com.project.ETS.responseDTO.TrainerResponse;
import com.project.ETS.responseDTO.UserResponse;

@Component
public class UserMapper {
	
	public User mapToUserEntity(RegistrationRequestDTO registrationRequestDTO, User user) {
		user.setUsername(registrationRequestDTO.getUsername());
		user.setEmail(registrationRequestDTO.getEmail());
		user.setPassword(registrationRequestDTO.getPassword());
		return user;
	}
	
	public Trainer mapToTrainerEntity(TrainerRequest trainerRequestDTO, Trainer trainer) {
		trainer.setUsername(trainerRequestDTO.getUsername());
		trainer.setEmail(trainerRequestDTO.getEmail());
		trainer.setSubjects(trainerRequestDTO.getSubjects());
		
		return trainer;
	}
	
	public Student mapToStudentEntity(StudentRequest studentRequestDTO, Student student) {
		student.setUsername(studentRequestDTO.getUsername());
		student.setEmail(studentRequestDTO.getEmail());
		student.setDegree(studentRequestDTO.getDegree());
		student.setStream(studentRequestDTO.getStream());
		student.setYop(studentRequestDTO.getYop());
		student.setDegreePercentage(studentRequestDTO.getDegreePercentage());
		student.setTenthPercentage(studentRequestDTO.getTenthPercentage());
		student.setTenthPercentage(studentRequestDTO.getTenthPercentage());
		student.setTwelvethPercentage(studentRequestDTO.getTwelvethPercentage());
		return student;
		
	}

	
	
	public UserResponse mapToUserResponse(User user) {
		UserResponse response = new UserResponse();
		response.setUserId(user.getUserId());
		response.setEmail(user.getEmail());
		response.setUsername(user.getUsername());
		return response;
	}
	
	public TrainerResponse mapToTrainerResponse(Trainer trainer) {
		TrainerResponse response = new TrainerResponse();
		response.setUserId(trainer.getUserId());
		response.setUsername(trainer.getUsername());
		response.setEmail(trainer.getEmail());
		response.setSubjects(trainer.getSubjects());
		
		return response;
	}
	
	public StudentResponse mapToStudentResponse(Student student) {
		StudentResponse response = new StudentResponse();
		response.setUserId(student.getUserId());
		response.setUsername(student.getUsername());
		response.setEmail(student.getEmail());
		response.setDegree(student.getDegree());
		response.setStream(student.getStream());
		response.setYop(student.getYop());
		response.setDegreePercentage(student.getDegreePercentage());
		response.setTenthPercentage(student.getTenthPercentage());
		response.setTenthPercentage(student.getTenthPercentage());
		response.setTwelvethPercentage(student.getTwelvethPercentage());
		return response;
	}

	

}
