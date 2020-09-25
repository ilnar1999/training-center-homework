package com.example.initialization;

import com.example.entity.Course;
import com.example.entity.Curriculum;
import com.example.service.CourseService;
import com.example.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseInitializer {

    @Autowired
    private CourseService courseService;
    @Autowired
    private CurriculumService curriculumService;

    public void initialize() {
        Curriculum curriculum = curriculumService.getByTitle("J2EE Developer");
        this.courseService.add(new Course("���������� Java Servlets", 16, curriculum));
        this.courseService.add(new Course("Struts Framework", 24, curriculum));
        this.courseService.add(new Course("Spring Framework", 48, curriculum));
        this.courseService.add(new Course("Hibernate", 20, curriculum));
        curriculum = curriculumService.getByTitle("Java Developer");
        this.courseService.add(new Course("����� ���������� Java", 8, curriculum));
        this.courseService.add(new Course("���������� JFC/Swing", 16, curriculum));
        this.courseService.add(new Course("���������� JDBC", 16, curriculum));
        this.courseService.add(new Course("���������� JAX", 52, curriculum));
        this.courseService.add(new Course("���������� commons", 44, curriculum));
    }
}
