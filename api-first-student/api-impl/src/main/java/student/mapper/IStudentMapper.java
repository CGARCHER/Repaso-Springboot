package student.mapper;

import student.dto.StudentDTO;
import student.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IStudentMapper {
    StudentDTO studentToStudentDTO(Student student);
    List<StudentDTO> studentToStudentDTO(List<Student> students);
}
