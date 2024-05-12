package com.ronaldocutrim.todoAPI.services;

import com.ronaldocutrim.todoAPI.controllers.todo.TodoMapper;
import com.ronaldocutrim.todoAPI.controllers.todo.TodoRequestDto;
import com.ronaldocutrim.todoAPI.domain.entity.Todo;
import com.ronaldocutrim.todoAPI.domain.entity.User;
import com.ronaldocutrim.todoAPI.repositories.TodoRepository;
import com.ronaldocutrim.todoAPI.repositories.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public Todo createTodo(Todo todo, String email) {
        var optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            todo.setUser(optionalUser.get());
            todoRepository.save(todo);
        }
        return todo;
    }

    public List<Todo> getTodos(Todo todo) {
        var matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        var example = Example.of(todo, matcher);
        return todoRepository.findAll(example);
    }

    public Todo updateTodo(String todoId, TodoRequestDto todoRequestDto, User user) {
        return todoRepository
                .findById(todoId)
                .filter(todo -> todo.getUser().equals(user))
                .map(todo -> TodoMapper.mergeTodoFromDto(todoRequestDto, todo))
                .map(todoRepository::save)
                .orElseThrow(null);
    }
}
