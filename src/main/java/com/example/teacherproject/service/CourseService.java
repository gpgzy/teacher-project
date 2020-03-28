package com.example.teacherproject.service;

import com.example.teacherproject.entity.Course;
import com.example.teacherproject.entity.Student;
import com.example.teacherproject.entity.StudentElectCourse;
import com.example.teacherproject.repository.CourseRepository;
import com.example.teacherproject.repository.StudentElectCourseRepository;
import com.example.teacherproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentElectCourseRepository studentElectCourseRepository;
    @Autowired
    private StudentRepository studentRepository;

    /**
     * 添加课程
     * 返回该课程教师的所有课程
     * @param course
     * @return
     */
    public List<Course> addCourse(Course course){
        courseRepository.save(course);
        List<Course> list = courseRepository.findByTeacher(course.getTeacher().getId());
        return list;
    }

    /**
     *添加学生返回课程信息
     * @param student
     * @param cid
     * @param score
     * @return
     */
    public Course addStudent(Student student,int cid,Integer score){
        Course course = courseRepository.findAllById(cid);
        if(student.getId()==null)
        {
            studentRepository.save(student);
        }
        StudentElectCourse studentElectCourse = new StudentElectCourse();
        studentElectCourse.setStudent(student);
        studentElectCourse.setCourse(course);
        studentElectCourse.setScore(score);
        studentElectCourseRepository.save(studentElectCourse);
        return course;
    }

    /**
     *
     * @param sid 学生id
     * @param cid 课程id
     * @param score
     * @return
     */
    public StudentElectCourse updateScore(int sid,int cid,int score) {
        StudentElectCourse studentElectCourse = studentElectCourseRepository.findAllByCourseAndStudent(sid,cid);
        studentElectCourseRepository.updateScoreById(studentElectCourse.getId(),score);
        return studentElectCourse;
    }
    public int updateCourseWeight(int cid,double weight){
        return courseRepository.updateWeightById(weight,cid);
    }
}
