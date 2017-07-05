package main.java.mbase.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot with Jenkins build automation..!<br /><h3>Menu</h3>"
        		+ "<ul>"
        		+ "<li><a href=\"/index.html\">Todo Manager</a></li>"
        		+ "<li><a href=\"/birthday.html\">Birthday Manager</a></li>"
        		+ "<ul>";
    }

    @RequestMapping("/about")
    public String about() {
        return "MBase personal assistant application";
    }

}