package com.example.teacherproject.repository;

import com.example.teacherproject.entity.Course;
import com.example.teacherproject.entity.Student;
import com.example.teacherproject.entity.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(value = false)
public class TeacherTest {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void init(){
        Teacher teacher = new Teacher();
        teacher.setName("ByWhyMan");
        teacher.setCurrentStu(5);
        teacher.setMaxStu(10);
        Student student = new Student();
        student.setName("gzy");
        student.setNumber("2017123");
        student.setTeacher(teacher);
        teacherRepository.save(teacher);
        studentRepository.save(student);
    }

    @Test
    public void test_findStudentsByTeacherName(){

    }
    @Test
    public void test_updateMaxStu(){
      teacherRepository.findAll().forEach(teacher -> {
          log.debug("{}",teacher.getName());
      });
        log.debug("{}",teacherRepository.updateMaxStu(15,8));
    }
}
