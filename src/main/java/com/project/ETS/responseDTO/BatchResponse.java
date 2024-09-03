package com.project.ETS.responseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.project.ETS.enums.Subject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BatchResponse {

	private String batchId;
	private String title;
	private List<Subject> subjects;
	private LocalDate startingDate;
	private LocalTime beginsAt;
	private LocalTime endsAt;

}
