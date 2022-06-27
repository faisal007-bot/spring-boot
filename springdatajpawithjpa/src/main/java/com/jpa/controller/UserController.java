package com.jpa.controller;

import com.jpa.model.User;
import com.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/users")
    public ResponseEntity<List<User>> saveAllUsers(@RequestBody List<User> users) {
        List<User> users1 = service.saveUsers(users);
        return ResponseEntity.ok(users1);
    }

    @GetMapping("/users/sorted/{field}")
    public ResponseEntity<List<User>> getSortedUsers(@PathVariable("field") String field) {
        List<User> users = service.sortedUsers(field);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/paginated/{offset}/{size}")
    public ResponseEntity<Page<User>> getPaginatedUsers(@PathVariable("offset") int offset,
                                                        @PathVariable("size") int size) {
        Page<User> users = service.paginatedUsers(offset, size);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/paginatedSorted/{offset}/{size}/{field}")
    public ResponseEntity<Page<User>> getPaginatedSortedUsers(@PathVariable("offset") int offset,
                                                              @PathVariable("size") int size,
                                                              @PathVariable("field") String field) {
        Page<User> users = service.getPaginatedSortedUsers(offset, size, field);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/count")
    public ResponseEntity<Long> getUsersCount() {
        Long aLong = service.countUsers();
        return ResponseEntity.ok(aLong);
    }

    @DeleteMapping("/users")
    public ResponseEntity<?> deleteAllUsersInBatch(){
        service.deleteAllInBatch();
        return ResponseEntity.ok("deleted all the users");
    }

    @DeleteMapping("/users/multiple")
    public ResponseEntity<?> deleteMultipleUsersInBatch(@RequestParam("ids")List<Integer> ids){
        service.deleteMultipleUsersInBatch(ids);
        return ResponseEntity.ok("deleted multiple users on the basis of the provided IDS");
    }
}
