package com.cgarcher.helloworld.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Handler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleNotFoundStudent(NotFoundStudentException ex){
        ErrorResponse error = new ErrorResponse(ex.getMessage(), 1111, "");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
