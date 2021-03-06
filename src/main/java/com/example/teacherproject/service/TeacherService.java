package com.example.teacherproject.service;

import com.example.teacherproject.entity.*;
import com.example.teacherproject.repository.StudentElectCourseRepository;
import com.example.teacherproject.repository.StudentRepository;
import com.example.teacherproject.repository.TeacherRepository;
import com.example.teacherproject.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Slf4j
@Transactional
public class TeacherService {

//    /**
//    登录
//     */
//    Teacher login(String user,String pwd);

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentElectCourseRepository studentElectCourseRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UserRepository userRepository;
    /**
     * 添加教师
     * 返回所有教师的信息
     * @param teacher
     * @return
     */
    public List<Teacher> addTeacher(Teacher teacher,User user){
        userRepository.save(user);
        teacher.setUser(user);
        teacherRepository.save(teacher);
        List<Teacher >list = teacherRepository.findAll();
        return list;
    }

    /**
     * 更改教师的最大学生数量
     * 返回该教师
     * @param tid
     * @param max
     * @return
     */
    public Teacher updateMaxStu(int tid,int max){
        teacherRepository.updateMaxStu(max,tid);
        Teacher teacher1 = teacherRepository.findAllById(tid) ;
        return  teacher1;
    }

    /**
     * 基于id给教师添加学生
     * @param student
     * @param tid
     * @return
     */
    public List<Student> addOneStudent(Student student,int tid){
        Teacher teacher = teacherRepository.findAllById(tid);
        student.setTeacher(teacher);
        if(student.getId()==null)
        {
            studentRepository.save(student);
        }
        int stuNo = teacher.getCurrentStu();
        stuNo++;
        teacherRepository.updateCurrentById(stuNo,teacher.getId());
        return teacher.getStudents();
    }

    /**
     *
     * @param tid
     * @return
     */
    public List<Course> getCourseByTeacherId(int tid){
       return teacherRepository.findAllById(tid).getCourses();
    }

    /**
     * 给所有学生排序
     * @return
     */
    public Map<Double,Student> sortAllStudents(){
        List<Student> list1 = studentRepository.findAll();
        Map<Double,Student> map = new TreeMap<Double,Student>(new Comparator<Double>(){
            public int compare(Double obj1,Double obj2){
                //降序排序
                return obj2.compareTo(obj1);
            }
        });
        for (Student student:list1)
        {
            double sum = 0;
            int i = 0;
            List<StudentElectCourse> list2 = student.getStudentElectCourseList();
            for (StudentElectCourse sc:list2) {
                i++;
                sum+=sc.getScore()*sc.getCourse().getWeight();
            }
            double arr = sum/(double)i;
            map.put(arr,student);

        }
        return map;
    }

    /**
     * 更改老师的密码
     * @param tid
     * @param resetWord
     * @return
     */
    public Teacher resetPassword(int tid,String resetWord){
        Teacher teacher = teacherRepository.findById(tid);
        PasswordEncoder p = new BCryptPasswordEncoder();
        String result = p.encode(resetWord);
        log.debug("{}",result);
        log.debug("{}",p.matches("123456",result));
        log.debug(resetWord);
        teacher.getUser().setPassword(result);
        return teacher;
    }

}
