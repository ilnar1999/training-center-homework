package com.example.service;

import com.example.entity.Course;
import com.example.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public boolean add(Course course) {
        if (course == null) {
            return false;
        }
        return this.courseRepository.add(course);
    }

    public Course getByTitle(String title) {
        if (title == null) {
            return null;
        }
        return this.courseRepository.getByTitle(title);
    }
}
