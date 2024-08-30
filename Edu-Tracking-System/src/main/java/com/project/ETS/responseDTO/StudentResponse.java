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
	private double degreePercentage;
	private double twelvethPercentage;
	private double tenthPercentage;
	

}
