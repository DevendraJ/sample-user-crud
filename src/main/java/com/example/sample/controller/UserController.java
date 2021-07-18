package com.example.sample.controller;

import com.example.sample.model.User;
import com.example.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/active")
    public List<User> getActiveUsers() {
        return userService.getActiveUsers();
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable(name = "id") Integer userId) {
        return userService.getUser(userId);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<String> saveUser(@RequestBody User newUser) {
        try {
            userService.saveUser(newUser);
            return new ResponseEntity<>("User saved successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable(name = "id") Integer userid, @RequestBody User user) {
        try {
            userService.updateUser(userid, user);
            return new ResponseEntity<>("Update performed successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
