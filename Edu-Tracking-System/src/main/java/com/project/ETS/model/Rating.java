package com.project.ETS.model;

import com.project.ETS.config.SequenceId;
import com.project.ETS.enums.Subjects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ratings")
public class Rating {
	
	@Id
	@SequenceId
	@Column(name = "ratingId")
	private String ratingId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "subject")
	private Subjects subject;
	
	@Column(name = "rating")
	private int rating;
	
	@Column(name = "feedback")
	private String feedback;
	
	@ManyToOne
	private Student student;
	

}
