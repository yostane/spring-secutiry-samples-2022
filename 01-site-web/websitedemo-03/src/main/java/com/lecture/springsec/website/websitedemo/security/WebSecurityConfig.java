package com.lecture.springsec.website.websitedemo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
                http
                                .authorizeRequests()
                                .antMatchers("/").permitAll()
                                .antMatchers("/**").authenticated()
                                .and()
                                .formLogin().permitAll()
                                .and().logout().permitAll()
                // .and().csrf().disable()
                ;
        }

        @Bean
        @Override
        public UserDetailsService userDetailsService() {
                List<UserDetails> users = new ArrayList<>();
                users.add(User.withDefaultPasswordEncoder()
                                .username("user").password("password").roles("USER")
                                .build());

                users.add(User.withDefaultPasswordEncoder()
                                .username("kakashi").password("password").roles("USER", "ADMIN")
                                .build());

                users.add(User.withDefaultPasswordEncoder()
                                .username("naruto").password("password").roles("STAGIAIRE")
                                .build());

                return new InMemoryUserDetailsManager(users);
        }
}
