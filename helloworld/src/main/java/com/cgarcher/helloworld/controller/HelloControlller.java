package com.cgarcher.helloworld.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloControlller {

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Bienvenido a mi app.");
        //return ResponseEntity.status(HttpStatus.OK).body("Bienvenido a mi app.");
    }

    @GetMapping("/number")
    public ResponseEntity<List<Integer>> lstNumbers(){

        /*
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);*/

        List<Integer> numbers = Arrays.asList(1,2,3,4);
        return ResponseEntity.ok(numbers);
    }
}
