package com.example.teacherproject.repository;


import com.example.teacherproject.entity.Hobby;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HobbyRepository extends BaseRepository<Hobby,Integer>{
    @Modifying
    @Query("update Hobby hobby set hobby.weight =:weight where hobby.id =:id")
    int updateWeight(@Param("weight") double weight,@Param("id") int id);
}
