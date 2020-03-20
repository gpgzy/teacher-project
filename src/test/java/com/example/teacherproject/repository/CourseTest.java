package com.example.teacherproject.repository;

import com.example.teacherproject.entity.Course;
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
    @Test

    public void init(){
        Course course = new Course();
        course.setName("java_Bo");
        course.setMinScore(60);
        course.setWeight(0.6);
        courseRepository.save(course);
    }
    @Test
    public void test_findByName(){

    }
}
