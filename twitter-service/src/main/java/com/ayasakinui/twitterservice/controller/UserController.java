package com.ayasakinui.twitterservice.controller;


import com.ayasakinui.twitterservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository repository;

    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/")
    public String user() {
        return String.valueOf(repository.findAll());
    }
}