package com.cinema.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//propably to delete


@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String getLoginToken() {
        return "";
    }


    @PostMapping("/register")
    public Boolean addNewUser() {
        return true;
    }


}
