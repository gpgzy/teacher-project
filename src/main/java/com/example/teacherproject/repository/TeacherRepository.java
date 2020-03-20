package com.example.teacherproject.repository;

import com.example.teacherproject.entity.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends BaseRepository<Teacher,Integer> {
}
