package com.example.service;

import com.example.entity.Student;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SortingService {

    public List<Student> sortByAverageMark(List<Student> students) {
        return students.stream().sorted(Comparator.comparing(Student::getAverageMark)).collect(Collectors.toList());
    }

    public List<Student> sortByTimeUntilFinishCurriculum(List<Student> students) {
        return students.stream().sorted(Comparator.comparing(Student::getCountOfDaysUntilFinishCurriculum)).collect(Collectors.toList());
    }
}
