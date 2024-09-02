package com.project.ETS.requestDTO;

import java.util.List;

import com.project.ETS.enums.Subject;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainerRequest extends UserRequest{

    @NotNull(message = "Subjects list cannot be null.")
    @NotEmpty(message = "Subjects list cannot be empty.")
    @Enumerated(EnumType.STRING)
    private List<@NotNull(message = "Subject cannot be null.") Subject> subjects;



}
