package com.cgarcher.helloworld.controller;

import com.cgarcher.helloworld.dto.CreateStudentRequest;
import com.cgarcher.helloworld.dto.StudentDTO;
import com.cgarcher.helloworld.dto.UpdateStudentRequest;
import com.cgarcher.helloworld.service.IStudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Get all students")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "List of students", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StudentDTO.class)))})})
    public ResponseEntity<List<StudentDTO>> getAll() {
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @PostMapping("/create")
    public ResponseEntity<StudentDTO> create(@RequestBody @Valid CreateStudentRequest createStudentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.createStudent(createStudentRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StudentDTO> delete(@PathVariable int id) {
        return ResponseEntity.ok(studentService.deleteStudent(id));

    }


    @PatchMapping("/update/{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable int id, @RequestBody UpdateStudentRequest updateStudentRequest){
        return ResponseEntity.
                ok(this.studentService.updateStudent
                        (id, updateStudentRequest));

    }
}
