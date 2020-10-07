package com.example.repository;

import com.example.entity.Student;
import com.example.service.FilterService;
import com.example.service.SortingService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    private FilterService filterService;
    @Autowired
    private SortingService sortingService;

    private List<Student> students = new ArrayList<>();

    public boolean add(@NonNull Student newStudent) {
        if (this.getByFullName(newStudent.getFullName()) != null) {
            return false;
        } else {
            this.students.add(newStudent);
            return true;
        }
    }

    public Student getByFullName(@NonNull String fullName) {
        for (Student student : this.students) {
            if (student.getFullName().equals(fullName)) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getStudents(String order, String filter) {
        List<Student> students = this.students;
        switch (filter) {
            case "may_continue":
                students = filterService.filterByStatusOfStudy(students);
                break;
        }
        switch (order) {
            case "time":
                students = this.sortingService.sortByTimeUntilFinishCurriculum(students);
                break;
            case "average":
                students = this.sortingService.sortByAverageMark(students);
                break;
        }
        return students;
    }
}
