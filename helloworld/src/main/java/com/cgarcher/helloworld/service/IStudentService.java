package com.cgarcher.helloworld.service;

import com.cgarcher.helloworld.dto.CreateStudentRequest;
import com.cgarcher.helloworld.dto.StudentDTO;

import java.util.List;

public interface IStudentService {
    List<StudentDTO> getAllStudent();
    StudentDTO createStudent(CreateStudentRequest createStudentRequest);
    StudentDTO deleteStudent(int id);
}
