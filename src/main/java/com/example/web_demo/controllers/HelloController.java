package com.example.web_demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Dzmitry Biatenia (dima@biatenia.smop.com)
 * Date:5/18/25
 */
@RestController
public class HelloController {

    @GetMapping(path = "/hello")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping(path = "/resort/{toResort}")
    public String resort(@PathVariable String toResort) {
        return "Resort: " + new StringBuilder(toResort).reverse() + " !!!";
    }
}
