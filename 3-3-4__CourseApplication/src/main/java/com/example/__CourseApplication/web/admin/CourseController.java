package com.example.__CourseApplication.web.admin;

import com.example.__CourseApplication.po.Course;
import com.example.__CourseApplication.service.CourseService;
import com.example.__CourseApplication.service.StudentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;
    //新增和修改
    @PostMapping("/edit")
    public String postCourse(Course course, BindingResult result, RedirectAttributes attributes) throws NotFoundException {
        Course c;
        if (course.getId() == null) {
            c=courseService.saveCourse(course);

        }else{
            c=courseService.updateCourse(course.getId(),course);
            System.out.println(course.getId().toString()+"update\n");
        }

        if(c==null){
            System.out.println("False\n");
            return "404";
        }else{
            System.out.println("True\n");
            return "400";
        }
    }
}