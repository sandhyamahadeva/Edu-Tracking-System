package com.project.ETS.requestDTO;

import java.time.Year;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest extends UserRequest{
	
	@NotBlank(message = "Degree is required")
	@Size(max = 100, message = "Degree must not exceed 100 character")
	private String degree;
	
	@NotBlank(message = "Stream is required")
	@Size(max = 100, message = "Stream must not exceed 100 character")
	private String stream;
	
	@NotBlank(message = "year of passing is required")
	@PastOrPresent(message = "Year of passing must be in the past or current year")
	private Year yop;
	
	@NotNull(message = "Degree percentage is required")
	@DecimalMin(value = "0.0",inclusive = false, message = "Degree percentage must be greater than 0" )
	@DecimalMax(value = "100.0", inclusive = true, message = "Degree percentage must be lesser that 100")
	private double degreePercentage;
	
	@NotNull(message = "Twelveth percentage is required")
	@DecimalMin(value = "0.0",inclusive = false, message = "Twelveth percentage must be greater than 0" )
	@DecimalMax(value = "100.0", inclusive = true, message = "Twelveth percentage must be lesser that 100")
	private double twelvethPercentage;
	
	@NotNull(message = "Tenth percentage is required")
	@DecimalMin(value = "0.0",inclusive = false, message = "Tenth percentage must be greater than 0" )
	@DecimalMax(value = "100.0", inclusive = true, message = "Tenth percentage must be lesser that 100")
	private double tenthPercentage;

}
