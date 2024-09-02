package com.project.ETS.exceptionhandler;

import com.project.ETS.exception.BatchNotFoundByIdException;
import com.project.ETS.utility.AppResponseBuilder;
import com.project.ETS.utility.ErrorStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class BatchExceptionHandler {
    private AppResponseBuilder responseBuilder;

    @ExceptionHandler(BatchNotFoundByIdException.class)
    public ResponseEntity<ErrorStructure<String>> handleBatchNotFoundById(BatchNotFoundByIdException exception){
        return responseBuilder.error(HttpStatus.NOT_FOUND, exception.getMessage(), "batch not found by given id");
    }
}
