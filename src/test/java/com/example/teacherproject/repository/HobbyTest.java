package com.example.teacherproject.repository;

import com.example.teacherproject.entity.Hobby;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(value = false)
public class HobbyTest {
    @Autowired
    private HobbyRepository hobbyRepository;
    @Autowired
    private UserRepository userRepository;
    @Test
    public void init(){
        Hobby hobby = new Hobby();
        hobby.setDetail("Java");
        hobby.setWeight(0.6);
        hobbyRepository.save(hobby);
    }
    @Test
    public void test_updateWeight(){
        log.debug("{}",hobbyRepository.updateWeight(0.8,1));
    }
    @Test
    public void yest_usertop(){
        log.debug("{}",userRepository.findMaxId());
        log.debug("{}",userRepository.findById(userRepository.findMaxId()));
        log.debug("{}",userRepository.findById(2).getPassword());
    }
}
