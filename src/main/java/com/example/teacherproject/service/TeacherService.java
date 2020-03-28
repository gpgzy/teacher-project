package com.example.teacherproject.service;

import com.example.teacherproject.entity.*;
import com.example.teacherproject.repository.StudentElectCourseRepository;
import com.example.teacherproject.repository.StudentRepository;
import com.example.teacherproject.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TeacherService {

//    /**
//    登录
//     */
//    Teacher login(String user,String pwd);
//    /**
//    * 显示所有的方向*/
//    List<Hobby> listHobby();
//    /**
//    /**
//     * 更改方向的权重*/
//    void updateHobbyWeight(int id,double weight);
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentElectCourseRepository studentElectCourseRepository;
    @Autowired
    private StudentRepository studentRepository;
    /**
     * 添加教师
     * 返回所有教师的信息
     * @param teacher
     * @return
     */
    public List<Teacher> addTeacher(Teacher teacher){
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
        int stuNo = teacher.getCurrentStu();
        stuNo++;
        teacherRepository.updateCurrentById(stuNo,teacher.getId());
        return teacherRepository.findStudentsByTeacherId(teacher.getId());
    }

    /**
     *
     * @param tid
     * @return
     */
    public List<Course> getCourseByTeacherId(int tid){
       return teacherRepository.findCourseByTeacherId(tid);
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
}
