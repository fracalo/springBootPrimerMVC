package com.example.demothymeleaf;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<Todo, Integer> { }

