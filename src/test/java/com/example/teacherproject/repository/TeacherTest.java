package com.example.teacherproject.repository;

import com.example.teacherproject.entity.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(value = false)
public class TeacherTest {
    @Autowired
    private TeacherRepository teacherRepository;
    @Test
    public void init(){
        Teacher teacher = new Teacher();
        teacher.setName("Bo");
        teacher.setCurrentStu(5);
        teacher.setMaxStu(10);
        teacherRepository.save(teacher);
    }
}
