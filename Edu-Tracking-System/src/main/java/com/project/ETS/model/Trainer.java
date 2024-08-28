package com.project.ETS.model;

import java.util.List;

import com.project.ETS.enums.Subjects;

import jakarta.persistence.Entity;

@Entity
public class Trainer extends User{
	
	private List<Subjects> subjects;

}
