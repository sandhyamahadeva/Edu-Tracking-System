package com.project.ETS.requestDTO;

import com.project.ETS.enums.Subjects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingRequest {
	private Subjects subject;
	private int rating;
	private String feedback;

}
