package com.cgarcher.mybatch.repository;

import com.cgarcher.mybatch.entity.StudentFinished;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentFinishedRepository extends JpaRepository<StudentFinished,Integer> {
}
