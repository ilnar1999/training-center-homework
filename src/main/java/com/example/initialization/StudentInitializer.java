package com.example.initialization;

import com.example.entity.Student;
import com.example.service.CurriculumService;
import com.example.service.StudentService;

import java.time.LocalDate;
import java.util.ArrayList;

public class StudentInitializer {

    private StudentService studentService;
    private CurriculumService curriculumService;

    public void initialize() {
        this.studentService.add(
                new Student("Ivanov Ivan", this.curriculumService.getByTitle("J2EE Developer"), LocalDate.now(), new ArrayList<>())
        );
        this.studentService.add(
                new Student("Petrov Petr", this.curriculumService.getByTitle("Java Developer"), LocalDate.of(2020, 2, 10), new ArrayList<>())
        );
    }
}