package com.project.ETS.responseDTO;

import java.util.List;

import com.project.ETS.enums.Subject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainerResponse extends UserResponse {

	private List<Subject> subjects;

}
