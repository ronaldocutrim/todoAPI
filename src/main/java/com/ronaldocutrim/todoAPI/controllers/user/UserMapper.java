package com.ronaldocutrim.todoAPI.controllers.user;

import com.ronaldocutrim.todoAPI.domain.entity.User;

public class UserMapper {
    public static User toEntity(UserRequestDto user) {
        return new User(user.name(), user.email());
    }
}
