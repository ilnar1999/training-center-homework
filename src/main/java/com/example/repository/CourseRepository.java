package com.example.repository;

import com.example.entity.Course;
import lombok.NonNull;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {

    private List<Course> courses = new ArrayList<>();

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
