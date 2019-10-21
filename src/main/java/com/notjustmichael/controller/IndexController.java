package com.notjustmichael.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

        @RequestMapping("/monks")
        public String login(){
            return "login.html";
        }

        @RequestMapping(value = {"/", "/monks"})
        public ResponseEntity<String> home() {
            return new ResponseEntity<>("Monks Delivery App", HttpStatus.OK);
        }
    }

