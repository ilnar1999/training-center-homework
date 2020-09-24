package com.example.repository;

import com.example.entity.Curriculum;
import lombok.NonNull;

import java.util.List;

public class CurriculumRepository {

    private List<Curriculum> curriculumList;

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
}
