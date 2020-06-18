package com.example.teacherproject.service;

import com.example.teacherproject.entity.Course;
import com.example.teacherproject.entity.Student;
import com.example.teacherproject.entity.Teacher;
import com.example.teacherproject.entity.User;
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
public class CourseTest {
    @Autowired
    private CourseService courseService;
    @Autowired
    private TeacherService teacherService;
    @Test
    public void test_addCourse(){
        Course course = new Course();
        course.setName("java");
        Teacher teacher = new Teacher();
        teacher.setName("Bo");
        teacher.setCurrentStu(10);
        teacher.setMaxStu(20);
        course.setMinScore(60);
        course.setTeacher(teacher);
        User user = new User();
        teacherService.addTeacher(teacher,user);
        courseService.addCourse(course).forEach(course1 -> {
            log.debug("{}",course1.getName());
        });
    }
    @Test
    public void test_addStudent(){
        Student student = new Student();
        student.setName("PonyMa");
        courseService.addStudent(student,9,60);
    }
    @Test
    public void test_updateScore(){
        courseService.updateScore(16,9,90);
    }
    @Test
    public void test_updateWeight(){
        log.debug("{}",courseService.updateCourseWeight(8,0.5));

    }
}
