package com.h2.database.service;

import com.h2.database.model.Student;
import com.h2.database.repository.StudentRepository;
import org.hibernate.dialect.H2Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<Student> saveStudents(List<Student> students) {
        List<Student> students1 = repository.saveAllAndFlush(students);
        return students1;
    }

    public List<Student> getStudents() {
        List<Student> students = repository.findAll();
        return students;
    }
}
