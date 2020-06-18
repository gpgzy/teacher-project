package com.example.teacherproject;

import com.example.teacherproject.interceptor.LoginInterceptor;
import com.example.teacherproject.interceptor.TeacherInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
//    @Bean//允许跨域请求
//    public CorsFilter corsFilter(){
//        CorsConfiguration config = new CorsConfiguration();
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//        config.addAllowedOrigin("*");
//        config.setAllowCredentials(true);
//        UrlBasedCorsConfigurationSource configSource
//                = new UrlBasedCorsConfigurationSource();
//        configSource.registerCorsConfiguration("/api/**",config);
//        return new CorsFilter(configSource);
//    }
    @Autowired
    private TeacherInterceptor teacherInterceptor;
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/login", "/api/test");

        registry.addInterceptor(teacherInterceptor)
                .addPathPatterns("/api/teacher/**"); }
}
