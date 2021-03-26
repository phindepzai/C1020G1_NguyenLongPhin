package com.binzet.concern;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Config {
    @Bean
    public Logger logger(){
        return new Logger();
    }
}
