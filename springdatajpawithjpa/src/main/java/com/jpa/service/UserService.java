package com.jpa.service;

import com.jpa.model.User;
import com.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> saveUsers(List<User> users){
        List<User> users1 = repository.saveAllAndFlush(users);
        return users1;
    }

    public List<User> sortedUsers(String field) {
        List<User> users = repository.findAll(Sort.by(Sort.Direction.DESC, field));
        return users;
    }

    public Page<User> paginatedUsers(int offset, int size) {
        Page<User> users = repository.findAll(PageRequest.of(offset, size));
        return users;
    }

    public Page<User> getPaginatedSortedUsers(int offset, int size, String field) {
        Page<User> users = repository.findAll(PageRequest.of(offset, size, Sort.by(Sort.Direction.DESC, field)));
        return users;
    }

    public void deleteAllInBatch() {
        repository.deleteAllInBatch();
    }

    public void deleteMultipleUsersInBatch(List<Integer> ids) {
        repository.deleteAllByIdInBatch(ids);
    }

    public Long countUsers() {
        long count = repository.count();
        return count;
    }
}
