package com.ronaldocutrim.todoAPI.services;

import com.ronaldocutrim.todoAPI.domain.entity.User;
import com.ronaldocutrim.todoAPI.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User loadUserByUsername(User user) throws UsernameNotFoundException {
        var optionalUser = userRepository.findByEmail(user.getEmail());
        if (optionalUser.isEmpty()) {
            userRepository.save(user);
        }
        return user;
    }
}
