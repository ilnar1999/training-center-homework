package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Course {

    @NonNull
    private String title;
    @NonNull
    private int duration;
    @NonNull
    private Curriculum curriculum;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return title.equals(course.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
