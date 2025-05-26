package com.cgarcher.helloworld.mapper;

import com.cgarcher.helloworld.dto.StudentDTO;
import com.cgarcher.helloworld.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IStudentMapper {
    StudentDTO studentToStudentDTO(Student student);
    List<StudentDTO> studentToStudentDTO(List<Student> students);
}
