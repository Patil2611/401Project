package com.blogapp.blogapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Empty {

    @GetMapping("")
    public ResponseEntity<String> empty() {
        return new ResponseEntity<>("Its is an empty page to check that server is working/ON", null, 200);
    }
}
