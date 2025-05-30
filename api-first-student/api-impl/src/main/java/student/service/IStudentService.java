package student.service;

import student.dto.CreateStudentRequest;
import student.dto.StudentDTO;
import student.dto.UpdateStudentRequest;

import java.util.List;

public interface IStudentService {
    List<StudentDTO> getAllStudent();
    StudentDTO createStudent(CreateStudentRequest createStudentRequest);
    StudentDTO deleteStudent(int id);
    StudentDTO updateStudent(int id, UpdateStudentRequest updateStudentRequest);
}
