package com.example.teacherproject.repository;

import com.example.teacherproject.entity.StudentElectHobby;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentElectHobbyRepository extends BaseRepository<StudentElectHobby,Integer> {
    @Modifying
    @Query("delete StudentElectHobby  sc  where sc.student.id=:sid and sc.hobby.id =:hid")
    int deleteByStudentAndHobby(@Param("sid")int sid,@Param("hid") int hid);
}
