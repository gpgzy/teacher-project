package com.example.teacherproject.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer maxStu;
    private Integer currentStu;
    private Double minScore;
    @OneToOne
    private User user;
    @OneToMany(mappedBy = "teacher")
    private List<Student> students;
    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;
    @Column(columnDefinition = "timestamp default current_timestamp ",
            insertable = false, updatable = false)
    private LocalDateTime insertTime;
}
