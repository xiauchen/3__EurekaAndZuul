package com.example.__PostNotesApplication.po;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "p_line")
public @Data class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="content")
    private String content;
    @Column(name="updateTime")
    private String updateTime;

    @ManyToOne
    @JoinColumn(name="title_id")
    private Title title;

    public Line(){}

    @Override
    public String toString() {
        return "Line{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", title=" + title + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
