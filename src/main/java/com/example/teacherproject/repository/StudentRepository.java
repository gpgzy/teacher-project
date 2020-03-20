package com.example.teacherproject.repository;

import com.example.teacherproject.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends BaseRepository<Student,Integer> {
}
