package com.lecture.springsec.restservice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class SecuredUserController {

    @PostMapping("logout")
    public boolean logout() {
        return true;
    }
}
