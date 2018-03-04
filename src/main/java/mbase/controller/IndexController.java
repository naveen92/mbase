package main.java.mbase.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot with Jenkins build automation..!<br /><h3>Menu</h3>"
        		+ "<ul>"
        		+ "<li><a href=\"/index.html\">Todo Manager</a></li>"
        		+ "<li><a href=\"/expense_manager.html\">Expense Manager</a></li>"
        		+ "<li><a href=\"/myblogger/navigator.html\">myblogger - Navigator</a></li>"
        		+ "<li><a href=\"/birthday.html\">Birthday Manager</a></li>"
        		+ "<li>Event Tracker</li>"
        		+ "<ul>";
    }

    @RequestMapping("/about")
    public String about() {
        return "MBase personal assistant application";
    }

}