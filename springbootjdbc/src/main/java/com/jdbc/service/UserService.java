package com.jdbc.service;

import com.jdbc.model.User;
import com.jdbc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public int saveUser(User user) {
        int i = repository.saveUser(user);
        return i;
    }

    public int updateUser(User user) {
        int i = repository.updateUser(user);
        return i;
    }

    public int deleteUser(int id) {
        int i = repository.deleteUser(id);
        return i;
    }

    public User getUser(int id) {
        User user = repository.getUser(id);
        return user;
    }

    public List<User> getUsers() {
        List<User> users = repository.getUsers();
        return users;
    }

    public int[] batchSaveUsers(List<User> users) {
        int[] batchSaveUsers = repository.batchSaveUsers(users);
        return batchSaveUsers;
    }

    public int[] batchUpdateUsers(List<User> users) {
        int[] batchUpdateUsers = repository.batchUpdateUsers(users);
        return batchUpdateUsers;
    }
}
