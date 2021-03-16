package com.api.board.jwtlogin.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@CrossOrigin
@ApiIgnore
public class HelloWorldController {
    @RequestMapping({ "/hello" })
    public String firstPage() {
        return "Hello. you have valid JWT (JSon Web Token)!";
    }
}
