package com.example.initialization;

import com.example.entity.Curriculum;
import com.example.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CurriculumInitializer {

    @Autowired
    private CurriculumService curriculumService;

    public void initialize() {
        this.curriculumService.add(new Curriculum("J2EE Developer", new ArrayList<>()));
        this.curriculumService.add(new Curriculum("Java Developer", new ArrayList<>()));
    }
}
