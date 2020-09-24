package com.example.repository;

import com.example.entity.Student;
import lombok.NonNull;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private List<Student> students = new ArrayList<>();

    public boolean add(@NonNull Student newStudent) {
        if (this.getByFullName(newStudent.getFullName()) != null) {
            return false;
        } else {
            this.students.add(newStudent);
            return true;
        }
    }

    public Student getByFullName(@NonNull String fullName) {
        for (Student student : this.students) {
            if (student.getFullName().equals(fullName)) {
                return student;
            }
        }
        return null;
    }
}
