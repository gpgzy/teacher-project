package com.example.teacherproject.repository;

import com.example.teacherproject.entity.Course;
import com.example.teacherproject.entity.Student;
import com.example.teacherproject.entity.StudentElectCourse;
import com.example.teacherproject.entity.Teacher;
import com.example.teacherproject.repository.impl.BaseRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
@Slf4j
public class CourseTest {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void init(){
        Course course = new Course();
        course.setName("web");
        course.setMinScore(60);
        course.setWeight(0.6);
        Teacher teacher = new Teacher();
        teacher.setName("gzy");
        teacher.setCurrentStu(5);
        teacher.setMaxStu(10);
        course.setTeacher(teacher);
        Student student = new Student();
        student.setName("gzyy");
        student.setNumber("2017123");
        teacherRepository.save(teacher);
        courseRepository.save(course);
    }
    @Test
    public void test_findByName(){
         courseRepository.findByTeacher(4).forEach(course -> {
             log.debug(course.getTeacher().getName());
         });
        courseRepository.findByTeacher(5).forEach(course -> {
            log.debug(course.getTeacher().getName());
        });

    }
}
