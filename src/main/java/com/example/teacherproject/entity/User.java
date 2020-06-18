package com.example.teacherproject.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public enum Role{
        STUDENT,TEACHER
    }
    private String username;
    private Role role;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @Column(columnDefinition = "timestamp default current_timestamp ",
            insertable = false, updatable = false)
    private LocalDateTime insertTime;
}
