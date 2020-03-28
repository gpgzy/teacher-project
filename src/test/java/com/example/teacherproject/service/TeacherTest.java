package com.example.teacherproject.service;

import com.example.teacherproject.entity.Student;
import com.example.teacherproject.entity.Teacher;
import com.example.teacherproject.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Slf4j
@SpringBootTest
@Transactional
@Rollback(value = false)
public class TeacherTest {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void test_addTeacher(){
        Teacher teacher = new Teacher();
        teacher.setName("JackMa");
        teacher.setCurrentStu(10);
        teacher.setMaxStu(20);
       teacherService.addTeacher(teacher).forEach(t->{
           log.debug("{}",t.getName());
       });
    }
    @Test
    public void test_updateMaxStu(){
        teacherService.updateMaxStu(14,25);
    }
    @Test
    public void test_addOneStudent(){
        Student student = new Student();
        student.setName("gzy1");
        studentRepository.save(student);
        teacherService.addOneStudent(student,14).forEach(student1 -> {
            log.debug("{}",student1.getName());
        });
    }
    @Test
    public void test_getCourseByTeacherId(){
        teacherService.getCourseByTeacherId(4).forEach(course -> {
            log.debug("{}",course.getName());
        });
    }
    @Test
    public void test_sortAllStudents(){
        Map<Double,Student> map = teacherService.sortAllStudents();
        for (Student student:map.values()){
            log.debug("{}",student.getName());
        }
        for (Double d:map.keySet()){
            log.debug("{}",d);
        }
    }
}
