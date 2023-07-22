package com.example.todolist.Controller;

import com.example.todolist.Entity.ToDo;
import com.example.todolist.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService toDoService;

    @GetMapping("/todo")
    public String helloController(Model model) {
        List<ToDo> toDoList = this.toDoService.findToDos();
        model.addAttribute("toDoList",toDoList);
        return "todolist";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/todo";
    }

    @PostMapping("/todo/create")
    public String todoCreate(@RequestParam String content){
        toDoService.saveTodo(content);
        return "redirect:/todo";
    }
}