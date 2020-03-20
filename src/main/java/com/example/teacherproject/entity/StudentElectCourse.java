package com.example.teacherproject.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class StudentElectCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;
    private double score;
    @Column(columnDefinition = "timestamp default current_timestamp ",
            insertable = false, updatable = false)
    private LocalDateTime insertTime;
}
