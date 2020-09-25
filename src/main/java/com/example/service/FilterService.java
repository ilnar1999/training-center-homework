package com.example.service;

import com.example.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilterService {

    public List<Student> filterByStatusOfStudy(List<Student> students) {
        return students.stream().filter(Student::isMayBeContinueTraining).collect(Collectors.toList());
    }
}
