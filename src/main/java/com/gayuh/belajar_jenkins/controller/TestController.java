package com.gayuh.belajar_jenkins.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1")
public class TestController {

    @GetMapping
    public ResponseEntity<Object> helloWorld() {
        Map<String, Object> response = Map.of(
                "message", "Hello World",
                "status", 200
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("{name}")
    public ResponseEntity<Object> helloPerson(@PathVariable(name = "name") String name) {
        Map<String, Object> response = Map.of(
                "message", "Hello " + name,
                "status", 200
        );

        return ResponseEntity.ok(response);
    }
}
