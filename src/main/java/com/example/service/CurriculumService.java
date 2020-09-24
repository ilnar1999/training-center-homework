package com.example.service;

import com.example.entity.Curriculum;
import com.example.repository.CurriculumRepository;

public class CurriculumService {
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
}
