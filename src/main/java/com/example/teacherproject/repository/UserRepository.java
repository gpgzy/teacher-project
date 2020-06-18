package com.example.teacherproject.repository;

import com.example.teacherproject.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User,Integer> {
    @Query("select u from User u where u.username =:uname")
    User findByName(@Param("uname") String uname);
    @Query("select max(u.id) from User u  ")
    Integer findMaxId();
    User findById(@Param("id")int id);

}
