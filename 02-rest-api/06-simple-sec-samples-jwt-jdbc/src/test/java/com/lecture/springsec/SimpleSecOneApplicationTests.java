package com.lecture.springsec;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;

import com.lecture.springsec.security.JwtTokenUtil;

// https://www.baeldung.com/spring-boot-testing
@SpringBootTest(classes = SpringRestApplication.class)
class SimpleSecOneApplicationTests {

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Test
    void testJWT() {
        var user = new User("John Doe", "password", Collections.emptyList());
        var token = jwtTokenUtil.generateToken(user);
        assertTrue(jwtTokenUtil.validateToken(token, user));
        assertEquals("John Doe", jwtTokenUtil.getUsernameFromToken(token));
    }

}
