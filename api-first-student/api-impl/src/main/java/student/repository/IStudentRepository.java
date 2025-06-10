package student.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByFinished(boolean finished);

    /*@Transactional
    @Modifying
    void deleteByName(String name);*/

    @Transactional
    @Modifying
    @Query("DELETE FROM Student stu " +
            "WHERE UPPER(stu.name) = UPPER(?1)")
    int deleteByName(String name);




}
