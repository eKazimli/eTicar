package org.example.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/v1/users")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.create(user);
        return ResponseEntity.ok(savedUser);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/active/{id}")
    public ResponseEntity<?> userActive(@PathVariable Long id) {
        userService.active(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.findUserById(userId));
    }

    @PutMapping("/increaseBalance/{id}/{replaceBalance}")
    public ResponseEntity<?> increaseBalance(@PathVariable Long id, @PathVariable Double replaceBalance) {
        userService.increaseBalance(id, replaceBalance);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/reduceBalance/{id}/{replaceBalance}")
    public ResponseEntity<?> reduceBalance(@PathVariable Long id, @PathVariable Double replaceBalance) {
        userService.reduceBalance(id, replaceBalance);
        return ResponseEntity.ok().build();
    }

}
