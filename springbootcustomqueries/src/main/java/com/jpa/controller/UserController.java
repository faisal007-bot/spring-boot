package com.jpa.controller;

import com.jpa.model.User;
import com.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    //    custom finder methods
    @PostMapping("/user")
    public ResponseEntity<List<User>> saveUsers(@RequestBody List<User> users) {
        List<User> users1 = service.saveUsers(users);
        return ResponseEntity.ok(users1);
    }

    @GetMapping("/userby/{id}/{name}")
    public ResponseEntity<List<User>> findByIdOrName(@PathVariable("id") int id, @PathVariable("name") String name) {
        List<User> users = service.findByIdOrName(id, name);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{start}/{end}")
    public ResponseEntity<List<User>> findByIdBetween(@PathVariable("start") int start, @PathVariable("end") int end) {
        List<User> users = service.findByIdBetween(start, end);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/usertop/{id}")
    public ResponseEntity<List<User>> findTop5ByIdSmallerThan(@PathVariable("id") int id) {
        List<User> users = service.findTop5ByIdSmallerThan(id);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/userin")
    public ResponseEntity<List<User>> findByIdIn(@RequestParam("ids") List<Integer> ids) {
        List<User> users = service.findByIdIn(ids);
        return ResponseEntity.ok(users);
    }

    //    executing JPQL queries
    @GetMapping("/usergreater/{id}")
    public ResponseEntity<List<User>> getUserGreaterThan(@PathVariable("id") int id) {
        List<User> users = service.getUserGreaterThan(id);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/userrange")
    public ResponseEntity<List<User>> getUsersInProvidedRange(@RequestParam("ids") List<Integer> ids) {
        List<User> users = service.getUsersInProvidedId(ids);
        return ResponseEntity.ok(users);
    }

    //    executing SQL queries
    @GetMapping("/userlessnative/{id}")
    public ResponseEntity<List<User>> getUserLessThanNative(@PathVariable("id") int id) {
        List<User> users = service.getUserLessThanNative(id);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/userrangenative")
    public ResponseEntity<List<User>> getUsersInProvidedRangeNative(@RequestParam("ids") List<Integer> ids) {
        List<User> users = service.getUsersInProvidedIdNative(ids);
        return ResponseEntity.ok(users);
    }

    //    named queries
    @GetMapping("/getuserbyid/{id}")
    public ResponseEntity<List<User>> selectById(@PathVariable("id") int id) {
        List<User> users = service.selectByIdInUser(id);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/getuserrange")
    public ResponseEntity<List<User>> selectByRange(@RequestParam("ids") List<Integer> ids) {
        List<User> users = service.selectInProvidedId(ids);
        return ResponseEntity.ok(users);
    }

    //    named native queries
    @GetMapping("/getuserbyidnative/{id}")
    public ResponseEntity<List<User>> selectByIdNative(@PathVariable("id") int id) {
        List<User> users = service.selectByIdInUserNative(id);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/getuserrangenative")
    public ResponseEntity<List<User>> selectByRangeNative(@RequestParam("ids") List<Integer> ids) {
        List<User> users = service.selectInProvidedIdNative(ids);
        return ResponseEntity.ok(users);
    }

}
