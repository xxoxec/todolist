package com.example.todolist.service;

import com.example.todolist.Entity.ToDo;
import com.example.todolist.Repository.ToDoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoRepository toDoRepository;

    @Transactional
    public void saveTodo(String content) {
        ToDo todo = new ToDo();
        todo.setContent(content);
        todo.setCompleted(false);
        toDoRepository.save(todo);
    }

    @Transactional
    public ToDo findOne(Long id) {
        return toDoRepository.findOne(id);
    }

    @Transactional
    public List<ToDo> findToDos() {
        return toDoRepository.findAll();
    }

    // 삭제 코드
    @Transactional
    public void deleteTodo(Long id) {
        ToDo findTodo = toDoRepository.findOne(id);
        if (findTodo == null)
            throw new IllegalArgumentException("해당 아이템이 없습니다.");
        toDoRepository.delete(findTodo);
    }
}