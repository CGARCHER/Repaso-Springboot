package com.cgarcher.helloworld.service;

import com.cgarcher.helloworld.dto.CreateStudentRequest;
import com.cgarcher.helloworld.dto.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAllStudent();
    Student createStudent(CreateStudentRequest createStudentRequest);
    Student deleteStudent(int id);
}
