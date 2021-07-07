package com.example.demothymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    TodoRepo todoRepo;

    public Todo todoById(Integer id) {
        return todoRepo.findById(id).get();
    }

    public List<Todo> allTodos() {
        return (List<Todo>) todoRepo.findAll();
    }

    public Todo save(Todo todo) {
        return todoRepo.save(todo);
    }

    public void delete(int id) {
        todoRepo.deleteById(id);
    }
}
