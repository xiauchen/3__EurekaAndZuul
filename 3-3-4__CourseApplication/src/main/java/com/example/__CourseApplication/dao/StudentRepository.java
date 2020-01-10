package com.example.__CourseApplication.dao;

import com.example.__CourseApplication.po.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByCourseId(Long courseId);

    @Query("select s from Student s where s.name like ?1")
    List<Student> findByQuery(String query, Pageable pageable);
}
