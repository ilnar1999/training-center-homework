package com.example.repository;

import com.example.entity.Course;
import lombok.NonNull;

import java.util.List;

public class CourseRepository {

    private List<Course> courses;

    public boolean add(@NonNull Course newCourse) {
        if (this.getByTitle(newCourse.getTitle()) != null) {
            return false;
        } else {
            this.courses.add(newCourse);
            return true;
        }
    }

    public Course getByTitle(@NonNull String title) {
        for (Course course : this.courses) {
            if (course.getTitle().equals(title)) {
                return course;
            }
        }
        return null;
    }
}
