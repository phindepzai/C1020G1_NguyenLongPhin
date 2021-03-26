package com.furama.config;

import com.furama.service.employees.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsImpl userDetails;

    @Autowired
    private DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetails).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(HttpSecurity security) throws Exception {
        security.csrf().disable();
        security.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();
        security.authorizeRequests().antMatchers("/customers/**","/details/**","/contracts/**","/services/**").access("hasAnyRole('ROLE_EMPLOYEE','ROLE_ADMIN')");
        security.authorizeRequests().antMatchers("/employees/**").access("hasRole('ROLE_ADMIN')");
        security.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
        security.authorizeRequests().and().formLogin().loginPage("/login").loginProcessingUrl("/check_login")
                .defaultSuccessUrl("/",true)
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login");
        security.authorizeRequests().and().rememberMe().rememberMeCookieName("remember").tokenRepository(this.persistentTokenRepository())
                .tokenValiditySeconds(60*60*2);
    }
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        return memory;
    }
}
