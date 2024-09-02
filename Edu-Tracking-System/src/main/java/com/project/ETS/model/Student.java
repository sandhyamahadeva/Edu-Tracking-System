package com.project.ETS.model;

import java.time.Year;
import java.util.List;

import com.project.ETS.enums.Stack;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "students")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Student extends User{
	@Column(name = "degree")
	private String degree;

	@Column(name = "stream")
	private String stream;

	@Column(name = "year_of_passout")
	private Year yearOfPassout;

	@Column(name = "degree_percentage")
	private int degreePercentage;

	@Column(name = "twelth_percentage")
	private int twelthPercentage;

	@Column(name = "tenth_percentage")
	private int tenthPercentage;

	@Column(name = "courses")
	@Enumerated(EnumType.STRING)
	private Stack stack;

	@OneToMany(mappedBy = "student")
	private List<Rating> ratings;
}
