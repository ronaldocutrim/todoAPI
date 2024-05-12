package com.ronaldocutrim.todoAPI.controllers.todo;

import com.ronaldocutrim.todoAPI.domain.entity.Todo;
import com.ronaldocutrim.todoAPI.domain.entity.User;
import com.ronaldocutrim.todoAPI.services.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos(Todo filter) {
        return ResponseEntity.ok(todoService.getTodos(filter));
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@AuthenticationPrincipal User user, @RequestBody TodoRequestDto todoRequestDto) {
        var todo = todoService.createTodo(TodoMapper.toEntity(todoRequestDto), user.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }

    @PatchMapping("{todoId}")
    public ResponseEntity<Todo> updateTodo(@AuthenticationPrincipal User user, @PathVariable String todoId, @RequestBody TodoRequestDto todoRequestDto) {
        var updatedTodo = todoService.updateTodo(todoId, todoRequestDto, user);
        return ResponseEntity.ok(updatedTodo);
    }
}
