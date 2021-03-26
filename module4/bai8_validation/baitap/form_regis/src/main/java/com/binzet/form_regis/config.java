package com.binzet.form_regis;

import com.binzet.form_regis.service.UserService;
import com.binzet.form_regis.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {
    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }
}
