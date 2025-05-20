package com.cgarcher.helloworld.controller;

import com.cgarcher.helloworld.dto.Student;
import com.cgarcher.helloworld.service.IStudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student/all")
    public ResponseEntity<List<Student>> getAll(){
        return ResponseEntity.ok(studentService.getAllStudent());
    }
}
