package com.project.ETS.model;

import java.util.List;

import com.project.ETS.enums.Subjects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "trainers")
@Getter
@Setter
public class Trainer extends User{
	
	private List<Subjects> subjects;

}
