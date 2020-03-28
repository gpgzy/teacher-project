package com.example.teacherproject.repository;

import com.example.teacherproject.entity.Course;
import com.example.teacherproject.entity.Student;
import com.example.teacherproject.entity.StudentElectCourse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringBootTest
@Transactional
@Rollback(value = false)
public class StudentElectiveCourseTest {
    @Autowired
    private StudentElectCourseRepository studentElectCourseRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void init(){
        Course course = new Course();
        course.setName("web");
        course.setMinScore(60);
        course.setWeight(0.6);
        Student student = new Student();
        student.setName("gzyy");
        student.setNumber("2017123");
        StudentElectCourse studentElectCourse = new StudentElectCourse();
        studentElectCourse.setCourse(course);
        studentElectCourse.setStudent(student);
        studentElectCourse.setScore(50);
        studentRepository.save(student);
        courseRepository.save(course);
        studentElectCourseRepository.save(studentElectCourse);
    }
    @Test
    public void test_findAllByCourseAndStudent(){
        log.debug("{}",studentElectCourseRepository.findAllByCourseAndStudent(16,9).getInsertTime());
    }


}
