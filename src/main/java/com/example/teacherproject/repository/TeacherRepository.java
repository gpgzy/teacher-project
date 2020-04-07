package com.example.teacherproject.repository;

import com.example.teacherproject.entity.Course;
import com.example.teacherproject.entity.Student;
import com.example.teacherproject.entity.Teacher;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface TeacherRepository extends BaseRepository<Teacher,Integer> {
    @Modifying
    @Query("update Teacher t set t.maxStu =:maxStu where t.id = :id")
    int updateMaxStu(@Param("maxStu") int maxStu,@Param("id") int id);
    Teacher findAllById(@Param("id") int id);
    @Modifying
    @Query("update Teacher t set t.currentStu =:stu where t.id=:id")
    int updateCurrentById(@Param("stu") int stu,@Param("id") int id);
    Teacher findById(@Param("id") int id);
}
