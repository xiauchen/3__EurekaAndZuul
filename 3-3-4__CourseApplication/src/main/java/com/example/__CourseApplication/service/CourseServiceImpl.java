package com.example.__CourseApplication.service;

import com.example.__CourseApplication.dao.CourseRepository;
import com.example.__CourseApplication.po.Course;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Transactional
    @Override
    public Course getCourse(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Page<Course> listCourse(Pageable pageable) {
        return courseRepository.findAll(pageable);
    }

    @Override
    public List<Course> listCourse() {
        return courseRepository.findAll();
    }


    @Override
    public List<Course> listCourse(String ids) { //1.2.3
        return courseRepository.findAllById(converToList(ids));
    }

    private List<Long> converToList(String ids){
        List<Long> list = new ArrayList<>();
        if(!"".equals(ids) && ids!=null){
            String[] idarray = ids.split(",");
            for(int i=0;i< idarray.length;i++){
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }

    @Transactional
    @Override
    public Course updateCourse(Long id, Course course) throws NotFoundException {
        Course t = courseRepository.findById(id).orElse(null);
        if(t == null){
            throw new NotFoundException("不存在該標簽");
        }

        return courseRepository.save(t);
    }

    @Transactional
    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course getCourseByName(String name) {
        return null;
    }

    @Override
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public List<Course> listCourseByStudentId(Long id) {
        return courseRepository.findByStudentId(id);
    }

    @Override
    public List<Course> listCourse(String query, Pageable pageable) {
        return courseRepository.findByQuery(query,pageable);
    }
}
