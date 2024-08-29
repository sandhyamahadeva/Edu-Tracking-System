package com.project.ETS.model;

import java.time.Year;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student extends User{
	
	@Column(name = "degree")
	private String degree;
	
	@Column(name = "stream")
	private String Stream;
	
	@Column(name = "yop")
	private Year yop;
	
	@Column(name = "degree_percentage")
	private int degreePercentage;
	
	@Column(name = "twelveth_percentage")
	private int twelvethPercentage;
	
	@Column(name = "tenth_percentage")
	private int tenthPercentage;

}
