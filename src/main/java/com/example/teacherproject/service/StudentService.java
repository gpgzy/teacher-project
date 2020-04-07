package com.example.teacherproject.service;

import com.example.teacherproject.entity.Hobby;
import com.example.teacherproject.entity.Student;
import com.example.teacherproject.entity.StudentElectHobby;
import com.example.teacherproject.entity.Teacher;
import com.example.teacherproject.repository.StudentElectHobbyRepository;
import com.example.teacherproject.repository.StudentRepository;
import com.example.teacherproject.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private TeacherRepository teacherRepository;
   @Autowired
    private StudentRepository studentRepository;
   @Autowired
   private StudentElectHobbyRepository studentElectHobbyRepository;
    //Student login(int stuNo);
    /**
     *基于教师的id给老师添加指定学生
     * @Param list 学生列表
     * @Param tid 教师的id
     * */
    public Teacher addStudents( List<Student> list, Integer tid){
        Teacher teacher = teacherRepository.findAllById(tid);
        int stu = 0;
            for (Student student:list)
            {
                if(student.getId()==null)
                {
                    studentRepository.save(student);
                }
                stu++;
                student.setTeacher(teacher);
                studentRepository.save(student);
            }
            stu+=teacher.getCurrentStu();
            teacherRepository.updateCurrentById(stu,teacher.getId());
        return teacher;
    }

    /**
     *
     * @param student
     * @param hobby
     * @return
     */
    public StudentElectHobby addHobby(Student student, Hobby hobby){
        StudentElectHobby studentElectHobby = new StudentElectHobby();
        studentElectHobby.setHobby(hobby);
        studentElectHobby.setStudent(student);
        studentElectHobbyRepository.save(studentElectHobby);
        return studentElectHobby;
    }

    /**
     *
     * @param sid
     * @param hid
     * @return
     */
    public int deleteHobby(int sid, int hid){

        return studentElectHobbyRepository.deleteByStudentAndHobby(sid,hid);
    }
}
