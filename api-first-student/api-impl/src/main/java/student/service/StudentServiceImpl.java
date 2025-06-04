package student.service;

import student.dto.CreateStudentRequest;
import student.dto.StudentDTO;
import student.dto.UpdateStudentRequest;
import student.entity.Student;
import student.exception.NotFoundStudentException;
import student.mapper.IStudentMapper;
import student.repository.IStudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    private final IStudentRepository studentRepository;
    private final IStudentMapper studentMapper;

    public StudentServiceImpl(IStudentRepository studentRepository, IStudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;

    }

    @Override
    public List<StudentDTO> getAllStudent() {
        return studentMapper.studentToStudentDTO
                (this.studentRepository.findAll());
    }

    @Override
    public List<StudentDTO> getAllStudentByFinished(boolean finished) {
        return  studentMapper.studentToStudentDTO
                (this.studentRepository.findByFinished(finished));
    }

    @Override
    public StudentDTO createStudent(CreateStudentRequest createStudentRequest) {

        Student student = Student.builder()
                .name(createStudentRequest.getName())
                .mail(createStudentRequest.getMail())
                .date_born(createStudentRequest.getDate_born())
                .build();


        return this.studentMapper.studentToStudentDTO
                (this.studentRepository.save(student));
    }

    @Override
    public StudentDTO deleteStudent(int id) {
            Optional<Student> opStudent = this.studentRepository.findById(id);

            if(opStudent.isEmpty()) {
                throw new NotFoundStudentException("Error al borrar estudiante");
            }
           this.studentRepository.deleteById(opStudent.get().getId());
           return  this.studentMapper.studentToStudentDTO(opStudent.get());
    }


    @Override
    public StudentDTO updateStudent(int id, UpdateStudentRequest updateStudentRequest) {
        Optional<Student> opStudent = this.studentRepository.findById(id);

        if(opStudent.isEmpty()) {
            throw new NotFoundStudentException("Error al encontrar al estudiante");
        }

        Student student = opStudent.get();

        if (updateStudentRequest.getName() != null) {
            student.setName(updateStudentRequest.getName());
        }

        if (updateStudentRequest.getMail() != null) {
            student.setMail(updateStudentRequest.getMail());
        }

        if (updateStudentRequest.getDate_born() != null) {
            student.setDate_born(updateStudentRequest.getDate_born());
        }

        return this.studentMapper.studentToStudentDTO
                (this.studentRepository.save(student));
    }



}
