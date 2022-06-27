package com.jpa.controller;

import com.jpa.model.User;
import com.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User user1 = service.saveUser(user);
        return ResponseEntity.ok(user1);
    }

    @PostMapping("/users")
    public ResponseEntity<List<User>> saveMultipleUsers(@RequestBody List<User> users) {
        List<User> users1 = service.saveUsers(users);
        return ResponseEntity.ok(users1);
    }

    @PutMapping("/user")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User user1 = service.updateUser(user);
        return ResponseEntity.ok(user1);
    }

    @PutMapping("/users")
    public ResponseEntity<List<User>> updateUsers(@RequestBody List<User> users) {
        List<User> users1 = service.updateUsers(users);
        return ResponseEntity.ok(users1);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
        service.deleteUser(id);
        return ResponseEntity.ok("user deleted");
    }

    @DeleteMapping("/users")
    public ResponseEntity<?> deleteMultipleUsers(@RequestParam("ids") List<Integer> ids) {
        service.deleteMultipleUsers(ids);
        return ResponseEntity.ok("deleted multiple users");
    }

    @DeleteMapping("/users/all")
    public ResponseEntity<?> deleteAllUsers() {
        service.deleteAllUsers();
        return ResponseEntity.ok("all users deleted");
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id) {
        User user = service.getUser(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getMultipleUsers(@RequestParam("ids") List<Integer> ids) {
        List<User> users = service.getMultipleUsers(ids);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = service.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
