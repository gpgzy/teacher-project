package com.example.teacherproject.service;

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
    private HobbyService hobbyService;
    @Test
    public void test_updateWeight(){
        hobbyService.updateWeightById(3,0.5);
    }
    @Test
    public void test_listHobby(){
        hobbyService.listHobby().forEach(hobby -> {
            log.debug("{}",hobby.getDetail());
        });
    }
}
