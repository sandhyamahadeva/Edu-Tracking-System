package com.project.ETS.responseDTO;

import com.project.ETS.enums.Subject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingResponse {
	private String ratingId;
	private Subject subject;
	private int rating;
	private String feedback;

}
