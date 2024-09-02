package com.project.ETS.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.project.ETS.config.SequenceId;
import com.project.ETS.enums.UserRole;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "users")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@EntityListeners(AuditingEntityListener.class)
public class User {

	@Id
	@Column(name = "userid")
	@SequenceId
	private String userId;

	@Column(name = "username")
	private String userName;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private UserRole role;

	@CreatedDate
	@Column(name = "createdDate")
	private LocalDateTime createdDate;

	@LastModifiedDate
	@Column(name = "modifiedDate")
	private LocalDateTime modifiedDate;
}
