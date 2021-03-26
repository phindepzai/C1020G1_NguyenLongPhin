package com.furama.config;

import com.furama.concern.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogConfig {
    @Bean
    public Logger logger(){
        return new Logger();
    }
}
