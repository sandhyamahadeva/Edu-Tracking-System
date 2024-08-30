package com.project.ETS.model;

import java.time.Year;
import java.util.List;

import com.project.ETS.enums.Stack;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
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
	private double degreePercentage;
	
	@Column(name = "twelveth_percentage")
	private double twelvethPercentage;
	
	@Column(name = "tenth_percentage")
	private double tenthPercentage;
	
	@Column(name = "courses")
	@Enumerated(EnumType.STRING)
	private Stack stack;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.REMOVE)
	private List<Rating> ratings;

}
