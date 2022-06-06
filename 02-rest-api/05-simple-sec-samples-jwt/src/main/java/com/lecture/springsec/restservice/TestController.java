package com.lecture.springsec.restservice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @PostMapping("/ttt")
    public boolean logout() {
        return true;
    }
}
