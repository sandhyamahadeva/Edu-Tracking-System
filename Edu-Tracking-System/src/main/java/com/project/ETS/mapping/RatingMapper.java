package com.project.ETS.mapping;

import org.springframework.stereotype.Component;

import com.project.ETS.model.Rating;
import com.project.ETS.requestDTO.RatingRequest;
import com.project.ETS.responseDTO.RatingResponse;

@Component
public class RatingMapper {

	public Rating mapToRatingEntity(RatingRequest ratingRequest,Rating rating) {
		rating.setRating(ratingRequest.getRating());
		rating.setFeedback(ratingRequest.getFeedback());
		return rating;
	}

	public RatingResponse mapToRatingReponse(Rating rating) {
		RatingResponse response = new RatingResponse();
		response.setRatingId(rating.getRatingId());
		response.setSubject(rating.getSubject());
		response.setRating(rating.getRating());
		response.setFeedback(rating.getFeedback());

		return response;
	}

}
