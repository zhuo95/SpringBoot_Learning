package com.zz.initializrstart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello controller
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
   public String hello(){
       return "Hello World!";
   }

}
