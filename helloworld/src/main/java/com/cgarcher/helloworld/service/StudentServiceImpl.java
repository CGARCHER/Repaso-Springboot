package com.cgarcher.helloworld.service;

import com.cgarcher.helloworld.dto.CreateStudentRequest;
import com.cgarcher.helloworld.dto.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements IStudentService {

    private Map<Integer, Student> students;

    public StudentServiceImpl() {
        //Voy a inicializar la lista de students
        initStudents();
    }

    @Override
    public List<Student> getAllStudent() {
        return students.values().stream().toList();
    }

    @Override
    public Student createStudent(CreateStudentRequest createStudentRequest) {
        Student student = new Student(createStudentRequest.getName(),
                createStudentRequest.getMail(),
                createStudentRequest.getDate_born());
        students.put(student.getId(), student);
        return student;
    }

    private void initStudents(){
        students = new HashMap<>();

        Student student = new Student("Junior",
                "poronga@gmail.com",
                LocalDate.of(2002, 12,12));
        students.put(student.getId(), student);

        student = new Student("Cipri",
                "cipri@gmail.com",
                LocalDate.of(2005, 5,5));

        students.put(student.getId(), student);

        student = new Student("Fátima",
                "cipri@gmail.com",
                LocalDate.of(2006, 1,1));
        students.put(student.getId(), student);
    }
}
