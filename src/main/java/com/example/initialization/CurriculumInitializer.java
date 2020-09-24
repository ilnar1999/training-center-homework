package com.example.initialization;

import com.example.entity.Curriculum;
import com.example.service.CurriculumService;

import java.util.ArrayList;

public class CurriculumInitializer {

    private CurriculumService curriculumService;

    void initialize() {
        this.curriculumService.add(new Curriculum("J2EE Developer", new ArrayList<>()));
        this.curriculumService.add(new Curriculum("Java Developer", new ArrayList<>()));
    }
}
