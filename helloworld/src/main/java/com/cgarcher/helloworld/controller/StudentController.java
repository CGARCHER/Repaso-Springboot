package com.cgarcher.helloworld.controller;

import com.cgarcher.helloworld.dto.CreateStudentRequest;
import com.cgarcher.helloworld.dto.StudentDTO;
import com.cgarcher.helloworld.service.IStudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentDTO>> getAll(){
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @PostMapping("/create")
    public ResponseEntity<StudentDTO> create(@RequestBody @Valid CreateStudentRequest createStudentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.createStudent(createStudentRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StudentDTO> delete(@PathVariable int id){
        return ResponseEntity.ok(studentService.deleteStudent(id));

    }
}
