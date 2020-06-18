package com.example.teacherproject.controller;

import com.example.teacherproject.component.EncryptComponent;
import com.example.teacherproject.component.MyToken;
import com.example.teacherproject.entity.Teacher;
import com.example.teacherproject.entity.User;
import com.example.teacherproject.service.TeacherService;
import com.example.teacherproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/api/")
@RestController
@Slf4j
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder encoder ;
    @Autowired
    private EncryptComponent encryptComponent;
    @Value("${my.teacher}")
    private String roleTeacher;
    @Value("${my.student}")
    private String roleStudent;

    @PostMapping("login")
    public Map login(@RequestBody User user, HttpServletResponse response){
        User user1 = Optional.ofNullable(userService.getUser(user.getUsername()))
                .filter(u ->encoder.matches(user.getPassword(),u.getPassword()))
                .orElseThrow(()->
                    new ResponseStatusException(HttpStatus.UNAUTHORIZED,"用户名或密码错误"));
        MyToken token = new MyToken();
        token.setUid(user1.getId());
        token.setRole(user1.getRole());
        String auth = encryptComponent.encryptToken(token);//将token加密后存储在字符串中
        response.setHeader(MyToken.AUTHORIZATION,auth);//将token放在请求的头部
        String roleCode;
        if(user1.getRole()== User.Role.STUDENT)
        {
            roleCode = roleStudent;
        }else {
            roleCode = roleTeacher;
        }
        return Map.of("role",roleCode);
    }

}
