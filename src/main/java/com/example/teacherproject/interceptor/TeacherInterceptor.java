package com.example.teacherproject.interceptor;

import com.example.teacherproject.component.RequestComponent;
import com.example.teacherproject.entity.User;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.persistence.Access;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
public class TeacherInterceptor implements HandlerInterceptor {
    @Autowired
    private RequestComponent requestComponent;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       if (requestComponent.getRole()!= User.Role.TEACHER){
           throw new ResponseStatusException(HttpStatus.FORBIDDEN,"无权限");
       }
        return true;
    }
}
