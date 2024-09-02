package com.project.ETS.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.project.ETS.config.SequenceId;
import com.project.ETS.enums.BatchStatus;
import com.project.ETS.enums.Subject;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Batches")
public class Batch {
	@Id
	@SequenceId
	@Column(name = "batchId")
	private String batchId;

	@Column(name = "title")
	private String title;

	@Column(name = "subjects")
	private List<Subject> subjects;

	@Column(name = "startingDate")
	private LocalDate startingDate;

	@Column(name = "closedDate")
	private LocalDate closedDate;

	@Column(name = "beginsAt")
	private LocalTime beginsAt;

	@Column(name = "endsAt")
	private LocalTime endsAt;

	@Column(name = "batchStatus")
	@Enumerated(EnumType.STRING)
	private BatchStatus batchStatus;

	@ManyToMany
	@Column(name = "students")
	private List<Student> students;
}
