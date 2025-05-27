package com.cgarcher.helloworld.service;

import com.cgarcher.helloworld.dto.CreateStudentRequest;
import com.cgarcher.helloworld.dto.StudentDTO;
import com.cgarcher.helloworld.dto.UpdateStudentRequest;

import java.util.List;

public interface IStudentService {
    List<StudentDTO> getAllStudent();
    StudentDTO createStudent(CreateStudentRequest createStudentRequest);
    StudentDTO deleteStudent(int id);
    StudentDTO updateStudent(int id, UpdateStudentRequest updateStudentRequest);
}
