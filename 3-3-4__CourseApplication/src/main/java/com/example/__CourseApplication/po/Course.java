package com.example.__CourseApplication.po;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
* */
@Entity
@Table(name="c_course")
public @Data
class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String location;
    private String teacher;
    private String time;
    private Integer studentNumber;

    @ManyToMany(mappedBy = "course")
    private List<Student> student = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updateTime")
    private Date updateTime;

    public Course() {
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", teacher='" + teacher + '\'' +
                ", time='" + time + '\'' +
                ", studentNumber=" + studentNumber +
                ", updateTime=" + updateTime +
                '}';
    }
}
