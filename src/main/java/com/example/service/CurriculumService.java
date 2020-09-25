package com.example.service;

import com.example.entity.Course;
import com.example.entity.Curriculum;
import com.example.repository.CurriculumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurriculumService {

    @Autowired
    private CurriculumRepository curriculumRepository;

    public boolean add(Curriculum curriculum) {
        if (curriculum == null) {
            return false;
        }
        return this.curriculumRepository.add(curriculum);
    }

    public Curriculum getByTitle(String title) {
        if (title == null) {
            return null;
        }
        return this.curriculumRepository.getByTitle(title);
    }

    public boolean addCourseInCurriculum(Curriculum curriculum, Course course) {
        return curriculumRepository.addCourseInCurriculum(curriculum, course);
    }
}
