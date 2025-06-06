package com.cgarcher.mybatch.service;

import com.cgarcher.mybatch.entity.StudentFinished;
import com.cgarcher.mybatch.mapper.IStudentFinishedMapper;
import com.cgarcher.mybatch.repository.IStudentFinishedRepository;
import org.generator.model.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentFinishedImpl implements IStudentFinishedService {

    private final IStudentFinishedRepository studentFinishedRepository;
    private final IStudentFinishedMapper studentFinishedMapper;

    public StudentFinishedImpl(IStudentFinishedRepository studentFinishedRepository, IStudentFinishedMapper studentFinishedMapper) {
        this.studentFinishedRepository = studentFinishedRepository;
        this.studentFinishedMapper = studentFinishedMapper;
    }

    @Override
    public List<String> createStudentsFinished(List<StudentDTO> students) {

        List<StudentFinished> lstStudentFinished =  studentFinishedMapper.studentDTOToStudentFinished(students);

        for (StudentFinished studentFinished : lstStudentFinished) {
            Optional<StudentFinished> stud = studentFinishedRepository.findById(studentFinished.getIdStudent());
            if(stud.isEmpty()){
                studentFinishedRepository.save(studentFinished);
            }

        }
        /*
        students.forEach(student -> {
            Optional<StudentFinished> stud = studentFinishedRepository.findById(student.getId());
            if(stud.isEmpty()){
                StudentFinished studentFinishedCreate
                        = studentFinishedMapper.studentDTOToStudentFinished(student);
                studentFinishedRepository.save(studentFinishedCreate);
            }
        });*/



        return List.of();
    }
}
