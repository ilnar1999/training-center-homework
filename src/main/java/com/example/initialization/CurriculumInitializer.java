package com.example.initialization;

import com.example.entity.Curriculum;
import com.example.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
@Lazy
public class CurriculumInitializer {

    @Autowired
    private CurriculumService curriculumService;

    @PostConstruct
    public void initialize() {
        this.curriculumService.add(new Curriculum("J2EE Developer", new ArrayList<>()));
        this.curriculumService.add(new Curriculum("Java Developer", new ArrayList<>()));
    }
}
