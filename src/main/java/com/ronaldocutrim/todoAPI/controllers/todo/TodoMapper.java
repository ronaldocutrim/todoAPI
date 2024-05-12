package com.ronaldocutrim.todoAPI.controllers.todo;

import com.ronaldocutrim.todoAPI.domain.entity.Todo;
import org.springframework.util.StringUtils;

public class TodoMapper {
    public static Todo toEntity(TodoRequestDto todo) {
        return new Todo(todo.description(), todo.completed());
    }

    public static Todo mergeTodoFromDto(TodoRequestDto todoRequestDto, Todo todoEntity) {
        final String description = StringUtils.hasText(todoRequestDto.description()) ? todoRequestDto.description() : todoEntity.getDescription();
        final boolean completed = todoRequestDto.completed() != null ? todoRequestDto.completed() : todoEntity.getCompleted();
        return new Todo(todoEntity.getId(), description, completed, todoEntity.getUser());
    }
}
