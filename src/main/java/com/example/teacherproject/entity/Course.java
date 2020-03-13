package com.example.teacherproject.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int minScore;
    private double weight;
    @OneToMany(mappedBy = "course")
    private List<StudentElectCourse> studentElectCourseList;
    @ManyToOne
    private Teacher teacher;
}
