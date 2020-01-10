package com.example.__CourseApplication.service;

import com.example.__CourseApplication.po.Student;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student saveStudent(Student student);

    Student getStudent(Long id);
//
//    Student getStudentByContext(String name);

    Page<Student> listStudent(Pageable pageable);

    List<Student> listStudent();

    List<Student> listStudent(String ids);

//    List<Student> listStudentTop(Integer size);

    Student updateStudent(Long id, Student Student) throws NotFoundException;

    void deleteStudent(Long id);

    List<Student> listStudentByCourseId(Long id);

    List<Student> listStudent(String query, Pageable pageable);

    Optional<Student> getStudentById(Long id);
}
