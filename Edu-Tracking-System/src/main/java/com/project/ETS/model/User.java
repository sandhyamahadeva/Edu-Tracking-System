package com.project.ETS.model;

import java.time.LocalDateTime;

import com.project.ETS.config.SequenceId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
	@SequenceId
	private int userId;
	private String username;
	private String email;
	private String password;
	private String role;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	

}
