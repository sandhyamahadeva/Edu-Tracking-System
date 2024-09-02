package com.project.ETS.responseDTO;

import java.time.Year;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse extends UserResponse {

	private String degree;
	private String stream;
	private Year yop;
	private int degreePercentage;
	private int tenthPercentage;
	private int twelthPercentage;
	

}
