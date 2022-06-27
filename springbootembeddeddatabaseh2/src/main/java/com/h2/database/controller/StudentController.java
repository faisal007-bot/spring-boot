package com.h2.database.controller;

import com.h2.database.model.Student;
import com.h2.database.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping("/users")
    public ResponseEntity<List<Student>> saveStudents(@RequestBody List<Student> students) {
        List<Student> students1 = service.saveStudents(students);
        return new ResponseEntity<>(students1, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = service.getStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
