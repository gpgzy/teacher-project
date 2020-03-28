package com.example.teacherproject.repository;

import com.example.teacherproject.entity.StudentElectCourse;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentElectCourseRepository extends BaseRepository<StudentElectCourse,Integer> {

@Query("select sc from StudentElectCourse sc where sc.student.id =:sid and  sc.course.id =:cid")
    StudentElectCourse findAllByCourseAndStudent(@Param("sid")int sid,@Param("cid") int cid);
@Modifying
@Query("update StudentElectCourse sc set sc.score =:score  where sc.id =:id")
    int updateScoreById(@Param("id") int id,@Param("score") int score);
}
