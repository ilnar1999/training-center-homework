package com.example.service;

import com.example.entity.Course;
import com.example.repository.CourseRepository;

public class CourseService {

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
