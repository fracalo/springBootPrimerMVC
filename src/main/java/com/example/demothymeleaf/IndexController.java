package com.example.demothymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.Integer.parseInt;

@Controller
public class IndexController {
    @Autowired
    TodoService todoService;

    @GetMapping("/")
    public String index(Model model) {

        var todos = todoService.allTodos();
        model.addAttribute("todos", todos);
        return "index";
    }

    @GetMapping("/todo")
    public String readTodo(@RequestParam(name = "id", required = false, defaultValue = "") String id, Model model) {
        var todo = id.isEmpty() ? new Todo() : todoService.todoById(parseInt(id));
        model.addAttribute("todo", todo);
        return "edit";
    }

    @PostMapping("/todo")
    public String todo(@ModelAttribute Todo todo, Model model) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        var n = dtf.format(now);

        if (todo.created_at.isEmpty()) {
            todo.setCreated_at(n);
        }

        todo.setUpdated_at(n);
        var updatedTodo = todoService.save(todo);

        model.addAttribute("todo", updatedTodo);
        return "edit";
    }
   
    @GetMapping("/todo/delete")
    public ModelAndView delete(@RequestParam(name = "id", required = false, defaultValue = "") String id, Model model) {
        todoService.delete(parseInt(id));

        var todos = todoService.allTodos();
        model.addAttribute("todos", todos);
        return new ModelAndView("redirect:/");
    }
}