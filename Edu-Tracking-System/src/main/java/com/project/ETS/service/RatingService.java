package com.project.ETS.service;

import com.project.ETS.exception.RatingNotFoundByIdException;
import com.project.ETS.mapping.RatingMapper;
import com.project.ETS.repo.RatingRepo;
import com.project.ETS.requestDTO.RatingRequest;
import com.project.ETS.responseDTO.RatingResponse;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RatingService {

	private RatingRepo ratingRepository;
	private RatingMapper ratingMapper;

	public RatingResponse updateStudentRating(RatingRequest request, String ratingId) {
		return ratingRepository.findById(ratingId).map(rating ->{
			rating= ratingMapper.mapToRatingEntity(request, rating);
			rating=ratingRepository.save(rating);
			return ratingMapper.mapToRatingReponse(rating);
		}).orElseThrow(()-> new RatingNotFoundByIdException("failed to update student rating"));
	}

}
