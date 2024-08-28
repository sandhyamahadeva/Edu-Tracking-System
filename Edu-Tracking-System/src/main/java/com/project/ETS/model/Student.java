package com.project.ETS.model;

import java.time.Year;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student extends User{
	
	private String degree;
	private String Stream;
	private Year yop;
	private int degreePercentage;
	private int twelvethPercentage;
	private int tenthPercentage;

}
