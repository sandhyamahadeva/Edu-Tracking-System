package com.project.ETS.responseDTO;

import com.project.ETS.enums.Subjects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingResponse {
	private String ratingId;
	private Subjects subject;
	private int rating;
	private String feedback;

}
