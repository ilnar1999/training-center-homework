package com.example.service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public boolean add(Student student) {
        if (student == null) {
            return false;
        }
        return this.studentRepository.add(student);
    }

    public Student getByFullName(String fullName) {
        if (fullName == null) {
            return null;
        }
        return this.studentRepository.getByFullName(fullName);
    }
}
