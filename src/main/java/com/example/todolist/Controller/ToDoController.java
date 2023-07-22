package com.example.todolist.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ToDoController {

    @GetMapping("/todo")
    @ResponseBody
    public String helloController() {
        return "hello";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/todo";
    }
}