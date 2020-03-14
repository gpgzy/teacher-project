package com.example.teacherproject.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String number;
    private String name;
    @ManyToOne
    private Teacher teacher;
    @OneToMany(mappedBy = "student")
    private List<StudentElectHobby> studentElectHobbyList;
    @OneToMany(mappedBy = "student")
    private List<StudentElectCourse> studentElectCourseList;
}
