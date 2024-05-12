package com.ronaldocutrim.todoAPI.repositories;

import com.ronaldocutrim.todoAPI.domain.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, String> {
}
