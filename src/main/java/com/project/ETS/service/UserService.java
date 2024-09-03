package com.project.ETS.service;

import java.util.List;
import java.util.Optional;

import com.project.ETS.mapping.RatingMapper;
import com.project.ETS.responseDTO.RatingResponse;
import org.springframework.stereotype.Service;

import com.project.ETS.enums.BatchStatus;
import com.project.ETS.enums.Stack;
import com.project.ETS.enums.UserRole;
import com.project.ETS.exception.UserNotFoundByIdException;
import com.project.ETS.mapping.UserMapper;
import com.project.ETS.model.Admin;
import com.project.ETS.model.HR;
import com.project.ETS.model.Rating;
import com.project.ETS.model.Student;
import com.project.ETS.model.Trainer;
import com.project.ETS.model.User;
import com.project.ETS.repo.RatingRepo;
import com.project.ETS.repo.UserRepository;
import com.project.ETS.requestDTO.BatchRequest;
import com.project.ETS.requestDTO.StudentRequest;
import com.project.ETS.requestDTO.TrainerRequest;
import com.project.ETS.requestDTO.UserRequest;
import com.project.ETS.responseDTO.BatchResponse;
import com.project.ETS.responseDTO.StudentResponse;
import com.project.ETS.responseDTO.UserResponse;
import com.project.ETS.security.RegistrationRequestDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

	private UserRepository userRepo;
	private UserMapper userMapper;
	private RatingRepo ratingRepository;
	private RatingMapper ratingMapper;

	public UserResponse saveUser(RegistrationRequestDTO registrationRequestDTO,UserRole role) {

		User user = null;

		switch (role) {
			case ADMIN -> user = new Admin();
			case HR -> user = new HR();
			case TRAINER -> user = new Trainer();
			case STUDENT -> user = new Student();

			default -> throw new IllegalArgumentException("Unexpected value: "+role);
		}

		if(user != null) {
			user = userMapper.mapToUserEntity(registrationRequestDTO, user);
			user.setRole(role);
			user = userRepo.save(user);
		}

		return userMapper.mapToUserResponse(user);
	}

	public UserResponse updateTrainer(TrainerRequest trainerRequest,String userId) {
		return userRepo.findById(userId).map((user)->{
			user = userMapper.mapToTrainerEntity(trainerRequest, (Trainer) user);
			user = userRepo.save(user);
			return userMapper.mapToUserResponse(user);
		}).orElseThrow(()-> new UserNotFoundByIdException("failed to update the trainer"));
	}

	public StudentResponse updateStudent(StudentRequest studentRequest,String userId) {
		return userRepo.findById(userId).map((user)->{
			user=userMapper.mapToStudentEntity(studentRequest, (Student)user);
			user=userRepo.save(user);
			return userMapper.mapToStudentResponse((Student) user);
		}).orElseThrow(()-> new UserNotFoundByIdException("failed to update student"));
	}

	public StudentResponse updateStudent(Stack stack, String userId) {
		return userRepo.findById(userId)
				.map(user ->{
					Student student = (Student) user;
					stack.getSubjects().forEach(subject -> {
						Rating rating = new Rating();
						rating.setSubject(subject);
						rating.setStudent(student);
						ratingRepository.save(rating);
					});
					student.setStack(stack);
					user = userRepo.save(student);
					return userMapper.mapToStudentResponse(student);
				}).orElseThrow(()-> new UserNotFoundByIdException("failed to update stack to the student"));
	}

	public List<RatingResponse> viewRating(String userId){
		return userRepo.findById(userId)
				.map(user ->{
					Student student = (Student) user;
					return student.getRatings()
							.stream()
							.map(rating -> ratingMapper.mapToRatingReponse(rating))
							.toList();
				}).orElseThrow(()-> new UserNotFoundByIdException("student is not found by the given id"));
	}
}
