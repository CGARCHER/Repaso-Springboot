package student.service;

import student.dto.CreateStudentRequest;
import student.dto.StudentDTO;
import student.dto.UpdateStudentRequest;

import java.util.List;

public interface IStudentService {
    List<StudentDTO> getAllStudent();
    List<StudentDTO> getAllStudentByFinished(boolean finished);
    StudentDTO createStudent(CreateStudentRequest createStudentRequest);
    StudentDTO deleteStudent(int id);
    StudentDTO updateStudent(int id, UpdateStudentRequest updateStudentRequest);
    boolean deleteByName(String name);
}