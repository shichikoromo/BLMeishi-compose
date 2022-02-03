package com.ayasakinui.twitterservice.controller;


import com.ayasakinui.twitterservice.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private final MemberRepository repository;

    @Autowired
    public MemberController(MemberRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/")
    public String user() {
        return String.valueOf(repository.findAll());
    }
}