package com.project.ETS.exceptionhandler;

import com.project.ETS.exception.RatingNotFoundByIdException;
import com.project.ETS.utility.AppResponseBuilder;
import com.project.ETS.utility.ErrorStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class RatingExceptionHandler {

    private AppResponseBuilder appResponseBuilder;

    @ExceptionHandler(RatingNotFoundByIdException.class)
    public ResponseEntity<ErrorStructure<String>> handleRatingNotFoundById(RatingNotFoundByIdException exception){
        return appResponseBuilder.error(HttpStatus.NOT_FOUND, exception.getMessage(), "rating not found by give id");
    }
}
