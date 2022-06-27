package com.jpa.service;

import com.jpa.model.User;
import com.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    //    custom finder methods
    public List<User> saveUsers(List<User> users) {
        List<User> users1 = repository.saveAllAndFlush(users);
        return users1;
    }

    public List<User> findByIdOrName(int id, String name) {
        List<User> users = repository.findByIdOrName(id, name);
        return users;
    }

    public List<User> findByIdBetween(int start, int end) {
        List<User> users = repository.findByIdBetween(start, end);
        return users;
    }

    public List<User> findTop5ByIdSmallerThan(int id) {
        List<User> users = repository.findTop5ByIdGreaterThan(id);
        return users;
    }

    public List<User> findByIdIn(List<Integer> ids) {
        List<User> users = repository.findByIdIn(ids);
        return users;
    }

    //    JPQL queries
    public List<User> getUserGreaterThan(int id) {
        List<User> users = repository.getUserGreaterThan(id);
        return users;
    }

    public List<User> getUsersInProvidedId(List<Integer> ids) {
        List<User> users = repository.getUsersInProvidedId(ids);
        return users;
    }

    //    SQL queries
    public List<User> getUserLessThanNative(int id) {
        List<User> users = repository.getUserLessThanNative(id);
        return users;
    }

    public List<User> getUsersInProvidedIdNative(List<Integer> ids) {
        List<User> users = repository.getUsersInProvidedIdNative(ids);
        return users;
    }

    //    named queries
    public List<User> selectByIdInUser(int id) {
        List<User> users = repository.selectByIdInUser(id);
        return users;
    }

    public List<User> selectInProvidedId(List<Integer> ids) {
        List<User> users = repository.selectInProvidedId(ids);
        return users;
    }

    //    named native queries
    public List<User> selectByIdInUserNative(int id) {
        List<User> users = repository.selectByIdInUserNative(id);
        return users;
    }

    public List<User> selectInProvidedIdNative(List<Integer> ids) {
        List<User> users = repository.selectInProvidedIdNative(ids);
        return users;
    }
}
