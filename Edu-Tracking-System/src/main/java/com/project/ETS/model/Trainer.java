package com.project.ETS.model;

import java.util.List;

import com.project.ETS.enums.Subject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "trainers")
@Getter
@Setter
public class Trainer extends User{

	@Column(name = "subjects")
	private List<Subject> subjects;

}
