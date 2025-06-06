package com.cgarcher.mybatch.mapper;

import com.cgarcher.mybatch.entity.StudentFinished;
import org.generator.model.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IStudentFinishedMapper {
    @Mapping(source = "id", target = "idStudent")
    StudentFinished studentDTOToStudentFinished(StudentDTO studentDTO);

    List<StudentFinished> studentDTOToStudentFinished(List<StudentDTO> studentsDTO);

}
