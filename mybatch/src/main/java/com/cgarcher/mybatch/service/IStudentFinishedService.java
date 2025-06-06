package com.cgarcher.mybatch.service;

import org.generator.model.StudentDTO;

import java.util.List;

public interface IStudentFinishedService
{
    List<String> createStudentsFinished(List<StudentDTO> students);
}
