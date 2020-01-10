package com.example.__CourseApplication.po;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "c_student")
public @Data
class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer grade;
    private Integer phoneNumber;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Course> course = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updateTime")
    private Date updateTime;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", phoneNumber=" + phoneNumber +
                ", updateTime=" + updateTime +
                '}';
    }
}
