package com.lecture.springsec.security;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/protectedGreeting", "/users/**").hasAnyRole("USER", "ADMIN")
                .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // bcrypt of 'password':
        // $2a$10$lHamYXOcefYUwmPsMpyXBe5HKiXuxnt0rt38YJNpa9KGQA2kzTXBa
        auth.inMemoryAuthentication().withUser("user")
                .password("$2a$10$lHamYXOcefYUwmPsMpyXBe5HKiXuxnt0rt38YJNpa9KGQA2kzTXBa").roles("USER")
                .and().withUser("admin").password("lHamYXOcefYUwmPsMpyXBe5HKiXuxnt0rt38YJNpa9KGQA2kzTXBa")
                .roles("ADMIN", "USER");
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
