package com.example.teacherproject.service;

import com.example.teacherproject.entity.User;
import com.example.teacherproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User getUser(String uname){
        return userRepository.findByName(uname);
    }
}
