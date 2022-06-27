package com.manytomany.service;

import com.manytomany.model.User;
import com.manytomany.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        User user1 = userRepository.saveAndFlush(user);
        return user1;
    }

    public List<User> saveUsers(List<User> users) {
        List<User> users1 = userRepository.saveAllAndFlush(users);
        return users1;
    }

    public User getUser(int userId) {
        User user = userRepository.findById(userId).get();
        return user;
    }

    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
