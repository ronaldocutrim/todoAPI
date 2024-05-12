package com.ronaldocutrim.todoAPI.controllers.user;

import com.ronaldocutrim.todoAPI.services.TokenService;
import com.ronaldocutrim.todoAPI.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final TokenService tokenService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> getUserToken(@RequestBody UserRequestDto userRequestDto) {
        var userEntity = UserMapper.toEntity(userRequestDto);
        var user = userService.loadUserByUsername(userEntity);
        var token = tokenService.generateToken(user);
        return ResponseEntity.ok(new UserResponseDto(token));
    }
}
