package com.cgarcher.helloworld.repository;

import com.cgarcher.helloworld.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> { }
