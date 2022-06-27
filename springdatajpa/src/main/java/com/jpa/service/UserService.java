package com.jpa.service;

import com.jpa.model.User;
import com.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        User save = repository.save(user);
        return save;
    }

    public List<User> saveUsers(List<User> users) {
        List<User> users1 = (List<User>) repository.saveAll(users);
        return users1;
    }

    public User updateUser(User user) {
        User update = repository.save(user);
        return update;
    }

    public List<User> updateUsers(List<User> users) {
        List<User> users1 = (List<User>) repository.saveAll(users);
        return users1;
    }

    public void deleteUser(int id) {
        repository.deleteById(id);
    }

    public void deleteMultipleUsers(List<Integer> ids) {
        repository.deleteAllById(ids);
    }

    public void deleteAllUsers() {
        repository.deleteAll();
    }

    public User getUser(int id) {
        Optional<User> byId = repository.findById(id);
        User user = byId.get();
        return user;
    }

    public List<User> getMultipleUsers(List<Integer> ids) {
        List<User> users = (List<User>) repository.findAllById(ids);
        return users;
    }

    public List<User> getAllUsers() {
        List<User> users = (List<User>) repository.findAll();
        return users;
    }
}
