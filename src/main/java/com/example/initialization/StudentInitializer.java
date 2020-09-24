package com.example.initialization;

import com.example.entity.Student;
import com.example.service.CurriculumService;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;

@Component
@Lazy
public class StudentInitializer {

    @Autowired
    private StudentService studentService;
    @Autowired
    private CurriculumService curriculumService;

    @PostConstruct
    public void initialize() {
        this.studentService.add(
                new Student("Ivanov Ivan", this.curriculumService.getByTitle("J2EE Developer"), LocalDate.now(), new ArrayList<>())
        );
        this.studentService.add(
                new Student("Petrov Petr", this.curriculumService.getByTitle("Java Developer"), LocalDate.of(2020, 2, 10), new ArrayList<>())
        );
    }
}
