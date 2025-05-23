package com.cgarcher.helloworld.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class Handler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleNotFoundStudent(NotFoundStudentException ex){
        ErrorResponse error = new ErrorResponse(ex.getMessage(), 1111, "");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<FieldErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        for(FieldError fieldError: ex.getBindingResult().getFieldErrors()){
            errors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new FieldErrorResponse(ex.getMessage()
                        ,"Errores de validación de datos de entrada"
                        ,HttpStatus.BAD_REQUEST.value()
                        ,errors));

    }
}
