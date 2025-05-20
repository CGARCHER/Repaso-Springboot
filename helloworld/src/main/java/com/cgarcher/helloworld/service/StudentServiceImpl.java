package com.cgarcher.helloworld.service;

import com.cgarcher.helloworld.dto.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    private List<Student> lstStudents;

    public StudentServiceImpl() {
        //Voy a inicializar la lista de students
        initLstStudent();
    }

    @Override
    public List<Student> getAllStudent() {
        return lstStudents;
    }

    private void initLstStudent(){
        lstStudents = new ArrayList<>();
        lstStudents.add(new Student("Junior",
                "poronga@gmail.com",
                LocalDate.of(2002, 12,12)));
        lstStudents.add(new Student("Cipri",
                "cipri@gmail.com",
                LocalDate.of(2005, 5,5)));
        lstStudents.add(new Student("Fátima",
                "cipri@gmail.com",
                LocalDate.of(2006, 1,1)));
    }
}
