package org.example.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository;

    public User create(User user) {
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }

    public void delete(Long id) {
        User user = userRepository.
                findById(id).
                orElseThrow(() -> new RuntimeException("User type not found"));
        user.setIsActive(false);
        userRepository.save(user);
    }

    public void active(Long id) {
        User user = userRepository.
                findById(id).
                orElseThrow(() -> new RuntimeException("User type not found"));
        user.setIsActive(true);
        userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void increaseBalance(Long id, Double money) {
        User user = userRepository.
                findById(id).
                orElseThrow(() -> new RuntimeException("User not found"));
        if (user.getIsActive()) {
            var newBalance = user.getBalance() + money;
            if (newBalance < 0) {
                throw new IllegalArgumentException("Balance cannot be negative");
            }
            user.setBalance(newBalance);
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User is not active");
        }
    }

    public void reduceBalance(Long id, Double money) {
        User user = userRepository.
                findById(id).
                orElseThrow(() -> new RuntimeException("User not found"));
        if (user.getIsActive()) {
            var newBalance = user.getBalance() - money;
            if (newBalance < 0) {
                throw new IllegalArgumentException("Balance cannot be negative");
            }
            user.setBalance(newBalance);
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User is not active");
        }
    }
}
