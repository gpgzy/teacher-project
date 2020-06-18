package com.example.teacherproject.component;

import com.example.teacherproject.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MyToken {
    public static final String AUTHORIZATION = "authorization";
    public static final String UID = "uid";
    public static final String ROLE = "role";
    public Integer uid;
    public User.Role role;
}
