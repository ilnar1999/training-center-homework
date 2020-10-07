package com.example.repository;

import com.example.entity.Course;
import com.example.entity.Curriculum;
import lombok.NonNull;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CurriculumRepository {

    private List<Curriculum> curriculumList = new ArrayList<>();

    public boolean add(@NonNull Curriculum newCurriculum) {
        if (this.getByTitle(newCurriculum.getTitle()) != null) {
            return false;
        } else {
            this.curriculumList.add(newCurriculum);
            return true;
        }
    }

    public Curriculum getByTitle(@NonNull String title) {
        for (Curriculum curriculum : this.curriculumList) {
            if (curriculum.getTitle().equals(title)) {
                return curriculum;
            }
        }
        return null;
    }

    public boolean addCourseInCurriculum(Curriculum curriculum, Course course) {
        List<Course> courses = curriculum.getCourses();
        if (!courses.contains(course)) {
            courses.add(course);
            curriculum.setCourses(courses);
            return true;
        }
        return false;
    }
}
