package com.example.teacherproject.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int maxStu;
    private int currentStu;
    @OneToMany(mappedBy = "teacher")
    private List<Student> students;
    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;
}
