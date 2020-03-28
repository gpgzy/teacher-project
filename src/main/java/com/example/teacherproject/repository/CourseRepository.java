package com.example.teacherproject.repository;

import com.example.teacherproject.entity.Course;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends BaseRepository<Course,Integer> {
@Query("select c from Course c where c.teacher.id=:id")
    List<Course> findByTeacher(@Param("id")int id);
    Course findAllById(@Param("id") int id);
    @Modifying
    @Query("update Course c set c.weight=:weight where c.id =:id")
    int updateWeightById(@Param("weight") double weight,@Param("id") int id);

}
