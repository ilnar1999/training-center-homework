package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Student {

    @NonNull
    private String fullName;
    @NonNull
    private Curriculum curriculum;
    @NonNull
    private LocalDate startDate;
    @NonNull
    private List<Integer> marks;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return fullName.equals(student.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }
}
