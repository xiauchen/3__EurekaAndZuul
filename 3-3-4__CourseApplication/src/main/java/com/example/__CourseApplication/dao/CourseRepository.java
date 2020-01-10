package com.example.__CourseApplication.dao;

import com.example.__CourseApplication.po.Course;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findByStudentId(Long studentId);

    @Query("select c from Course c where c.name like ?1")
    List<Course> findByQuery(String query, Pageable pageable);
}
