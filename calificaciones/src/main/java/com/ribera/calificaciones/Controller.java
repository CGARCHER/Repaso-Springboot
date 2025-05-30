package com.ribera.calificaciones;

import org.generator.api.StudentControllerApi;
import org.generator.model.CreateStudentRequest;
import org.generator.model.StudentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class Controller {

    private StudentControllerApi studentControllerApi;

    public Controller(StudentControllerApi studentControllerApi) {
        this.studentControllerApi = studentControllerApi;
    }

    @GetMapping("/execute")
    public ResponseEntity<List<StudentDTO>> execute(){
        return ResponseEntity.ok(studentControllerApi.getAll());
    }
}
