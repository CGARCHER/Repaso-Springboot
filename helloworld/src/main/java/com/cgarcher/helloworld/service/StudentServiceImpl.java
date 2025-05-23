package com.cgarcher.helloworld.service;

import com.cgarcher.helloworld.dto.CreateStudentRequest;
import com.cgarcher.helloworld.dto.StudentDTO;
import com.cgarcher.helloworld.entity.Student;
import com.cgarcher.helloworld.exception.NotFoundStudentException;
import com.cgarcher.helloworld.repository.IStudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements IStudentService {
    //Spolier:desaparecerá
    private Map<Integer, StudentDTO> students;
    private final IStudentRepository studentRepository;

    public StudentServiceImpl(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        //Voy a inicializar la lista de students
        initStudents();
    }

    @Override
    public List<StudentDTO> getAllStudent() {
        List<Student> lstStudent = this.studentRepository.findAll();
        List<StudentDTO> lstStudentDTO = new ArrayList<>();
        for (Student student : lstStudent) {
            lstStudentDTO.add(new StudentDTO(student.getName(),
                    student.getMail(), student.getDate_born()));
        }
        return lstStudentDTO;
    }

    @Override
    public StudentDTO createStudent(CreateStudentRequest createStudentRequest) {
        StudentDTO student = new StudentDTO(createStudentRequest.getName(),
                createStudentRequest.getMail(),
                createStudentRequest.getDate_born());
        students.put(student.getId(), student);
        return student;
    }

    @Override
    public StudentDTO deleteStudent(int id) {

        if(!students.containsKey(id)){
            throw new NotFoundStudentException("Error al borrar estudiante");
        }
        return students.remove(id);
    }

    private void initStudents(){
        students = new HashMap<>();

        StudentDTO student = new StudentDTO("Junior",
                "poronga@gmail.com",
                LocalDate.of(2002, 12,12));
        students.put(student.getId(), student);

        student = new StudentDTO("Cipri",
                "cipri@gmail.com",
                LocalDate.of(2005, 5,5));

        students.put(student.getId(), student);

        student = new StudentDTO("Fátima",
                "cipri@gmail.com",
                LocalDate.of(2006, 1,1));
        students.put(student.getId(), student);
    }
}
