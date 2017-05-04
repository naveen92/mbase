package main.java.mbase.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot with Jenkins build automation..!";
    }

    @RequestMapping("/hello")
    public String say_hello() {
        return "Hey, Hello..";
    }

    @RequestMapping("/hello/{name}")
    public String say_hello_by_name(@PathVariable("name") String name) {
        return "Hey, Hello " + name;
    }

}