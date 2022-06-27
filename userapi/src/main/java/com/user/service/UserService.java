package com.user.service;

import com.user.model.User;
import com.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User saveUser(User user){
        User user1 = userRepository.saveAndFlush(user);
        return user1;
    }
    public List<User> saveUsers(List<User> users){
        List<User> users1 = userRepository.saveAllAndFlush(users);
        return users1;
    }
    public User updateUser(User user){
        User user1 = userRepository.save(user);
        return user1;
    }
}
