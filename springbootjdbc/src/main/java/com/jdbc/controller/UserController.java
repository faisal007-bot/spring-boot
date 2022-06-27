package com.jdbc.controller;

import com.jdbc.model.User;
import com.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/user")
    public ResponseEntity<Integer> saveUser(@RequestBody User user) {
        int i = service.saveUser(user);
        return ResponseEntity.ok(i);
    }

    @PutMapping("/user")
    public ResponseEntity<Integer> updateUser(@RequestBody User user) {
        int i = service.updateUser(user);
        return ResponseEntity.ok(i);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Integer> deleteUser(@PathVariable("id") int id) {
        int i = service.deleteUser(id);
        return ResponseEntity.ok(i);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = service.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id) {
        User user = service.getUser(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/user/save")
    public ResponseEntity<String> batchSaveUsers(@RequestBody List<User> users) {
        int[] batchSaveUsers = service.batchSaveUsers(users);
        return ResponseEntity.ok("all users saved");
    }

    @PutMapping("/user/update")
    public ResponseEntity<String> batchUpdateUsers(@RequestBody List<User> users) {
        int[] batchUpdateUsers = service.batchUpdateUsers(users);
        return ResponseEntity.ok("all users updated");
    }
}
