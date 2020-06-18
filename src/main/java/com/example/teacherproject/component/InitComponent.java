package com.example.teacherproject.component;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class InitComponent implements InitializingBean{
    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
