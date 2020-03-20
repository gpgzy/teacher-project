package com.example.teacherproject;

import com.example.teacherproject.repository.BaseRepository;
import com.example.teacherproject.repository.impl.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class TeacherProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeacherProjectApplication.class, args);
    }

}
