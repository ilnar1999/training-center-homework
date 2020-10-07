package com.example.initialization;

import com.example.entity.Course;
import com.example.entity.Curriculum;
import com.example.service.CourseService;
import com.example.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Lazy
public class CourseInitializer implements Initializer {

    @Autowired
    private CourseService courseService;
    @Autowired
    private CurriculumService curriculumService;


    @Override
    @PostConstruct
    public void initialize() {
        Curriculum curriculum = curriculumService.getByTitle("J2EE Developer");
        this.courseService.add(new Course("Технология Java Servlets", 16, curriculum));
        this.courseService.add(new Course("Struts Framework", 24, curriculum));
        this.courseService.add(new Course("Spring Framework", 48, curriculum));
        this.courseService.add(new Course("Hibernate", 20, curriculum));
        curriculum = curriculumService.getByTitle("Java Developer");
        this.courseService.add(new Course("Обзор технологий Java", 8, curriculum));
        this.courseService.add(new Course("Библиотека JFC/Swing", 16, curriculum));
        this.courseService.add(new Course("Технология JDBC", 16, curriculum));
        this.courseService.add(new Course("Технология JAX", 52, curriculum));
        this.courseService.add(new Course("Библиотеки commons", 44, curriculum));
    }
}
