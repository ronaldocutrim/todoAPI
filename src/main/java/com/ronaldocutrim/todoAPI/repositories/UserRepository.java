package com.ronaldocutrim.todoAPI.repositories;

import com.ronaldocutrim.todoAPI.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}
