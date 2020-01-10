package com.example.__PostNotesApplication.po;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "p_title")
public @Data class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter @Setter
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "life")
    private boolean life;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createTime")
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updateTime")
    private Date updateTime;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deadTime")
    private Date deadTime;

    @OneToMany(mappedBy = "title",cascade = CascadeType.ALL)
    private List<Line> line = new ArrayList<>();

    public Title(){}

    @Override
    public String toString() {
        return "Title{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deadTime=" + deadTime +
                ", life=" + life +
                '}';
    }

}
