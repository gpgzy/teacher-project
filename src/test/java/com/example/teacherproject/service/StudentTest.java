package com.example.teacherproject.service;

import com.example.teacherproject.entity.Hobby;
import com.example.teacherproject.entity.Student;
import com.example.teacherproject.repository.HobbyRepository;
import com.example.teacherproject.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(value = false)
public class StudentTest {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private HobbyRepository hobbyRepository;
    @Test
    public void test_insertStudents(){
        Student student1 = new Student() ;
        Student student2 = new Student();
        student1.setName("张三");
        student2.setName("里斯");
        List<Student> list = new LinkedList<>();
        list.add(student1);
        list.add(student2);
        log.debug("{}",studentService.addStudents(list,8).getName());

    }
    @Test
    public void test_addHobby(){
        Student student1 = new Student() ;
        Student student2 = new Student();
        student1.setName("张三");
        student2.setName("里斯");
        Hobby hobby = new Hobby();
        hobby.setDetail("sing,dance,rap");
        studentRepository.save(student1);
        studentRepository.save(student2);
        hobbyRepository.save(hobby);
        log.debug("{}",studentService.addHobby(student1,hobby).getInsertTime());

    }
    @Test
    public void test_deleteHobby(){

        log.debug("{}",studentService.deleteHobby(26,6));
    }
}
