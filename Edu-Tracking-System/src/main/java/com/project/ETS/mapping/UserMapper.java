package com.project.ETS.mapping;

import org.springframework.stereotype.Component;

import com.project.ETS.model.Student;
import com.project.ETS.model.Trainer;
import com.project.ETS.model.User;
import com.project.ETS.requestDTO.StudentRequest;
import com.project.ETS.requestDTO.TrainerRequest;
import com.project.ETS.responseDTO.StudentResponse;
import com.project.ETS.responseDTO.TrainerResponse;
import com.project.ETS.responseDTO.UserResponse;
import com.project.ETS.security.RegistrationRequestDTO;

@Component
public class UserMapper {

	public User mapToUserEntity(RegistrationRequestDTO registerationRequestDTO,User user) {
		user.setUserName(registerationRequestDTO.getUsername());
		user.setEmail(registerationRequestDTO.getEmail());
		user.setPassword(registerationRequestDTO.getPassword());
		return user;
	}

	public UserResponse mapToUserResponse(User user) {
		UserResponse response  = new UserResponse();
		response.setUserId(user.getUserId());
		response.setUserName(user.getUserName());
		response.setEmail(user.getEmail());
		return response;
	}

	public Student mapToStudentEntity(StudentRequest studentRequestDTO, Student student) {
		student.setUserName(studentRequestDTO.getUsername());
		student.setEmail(studentRequestDTO.getEmail());
		student.setDegree(studentRequestDTO.getDegree());
		student.setStream(studentRequestDTO.getStream());
		student.setYearOfPassout(studentRequestDTO.getYop());
		student.setDegreePercentage(studentRequestDTO.getDegreePercentage());
		student.setTenthPercentage(studentRequestDTO.getTenthPercentage());
		student.setTwelthPercentage(studentRequestDTO.getTwelvethPercentage());
		return student;
	}

	public StudentResponse  mapToStudentResponse(Student student) {
		StudentResponse response = new StudentResponse();
		response.setUserId(student.getUserId());
		response.setUserName(student.getUserName());
		response.setEmail(student.getEmail());
		response.setDegree(student.getDegree());
		response.setStream(student.getStream());
		response.setYop(student.getYearOfPassout());
		response.setDegreePercentage(student.getDegreePercentage());
		response.setTenthPercentage(student.getTenthPercentage());
		response.setTwelthPercentage(student.getTwelthPercentage());
		return response;
	}

	public Trainer mapToTrainerEntity(TrainerRequest trainerRequest,Trainer trainer) {
		trainer.setUserName(trainerRequest.getUsername());
		trainer.setEmail(trainerRequest.getEmail());
		trainer.setSubjects(trainerRequest.getSubjects());
		return trainer;
	}

	public TrainerResponse mapToTrainerResponse(Trainer trainer) {
		TrainerResponse response = new TrainerResponse();
		response.setUserId(trainer.getUserId());
		response.setUserName(trainer.getUserName());
		response.setEmail(trainer.getEmail());
		response.setSubjects(trainer.getSubjects());
		return response;
	}
}
