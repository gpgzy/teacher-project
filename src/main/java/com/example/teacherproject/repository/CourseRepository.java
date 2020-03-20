package com.example.teacherproject.repository;

import com.example.teacherproject.entity.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends BaseRepository<Course,Integer> {
@Query("select c from Course c where c.teacher.id=:id")
    List<Course> findByTeacher(@Param("id")int id);
}
