package com.example.entity;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Data
public class Student {

    @NonNull
    private String fullName;
    @NonNull
    private Curriculum curriculum;
    @NonNull
    private LocalDate startDate;
    @NonNull
    private List<Integer> marks;
    @NonNull
    private int countOfDaysUntilFinishCurriculum;
    @NonNull
    private double averageMark;
    @NonNull
    private boolean mayBeContinueTraining;


    public Student(@NonNull String fullName, @NonNull Curriculum curriculum, @NonNull LocalDate startDate, @NonNull List<Integer> marks) {
        this.fullName = fullName;
        this.curriculum = curriculum;
        this.startDate = startDate;
        this.setMarks(marks);
    }


    public void setMarks(List<Integer> marks) {
        this.marks = marks;
        this.setCountOfDaysUntilFinishCurriculum();
        this.setAverageMark();
        this.setMayBeContinueTraining();
    }

    public void setCountOfDaysUntilFinishCurriculum() {
        int totalCountOfHours = curriculum.getCourses().stream().mapToInt(Course::getDuration).sum();
        int totalCountOfDays = totalCountOfHours % 8 == 0 ? totalCountOfHours / 8 : totalCountOfHours / 8 + 1;
        int countOfFinishedDays = this.marks.size();
        this.countOfDaysUntilFinishCurriculum =  totalCountOfDays - countOfFinishedDays;
    }

    public void setAverageMark() {
        this.averageMark = marks.stream().mapToInt(mark -> mark).average().orElse(0);
        this.averageMark = (int) (averageMark * 10) / 10.0;
    }

    public void setMayBeContinueTraining() {
        int countCurrentMarks = this.marks.size();
        int countRemainingMarks = this.countOfDaysUntilFinishCurriculum;
        int totalCountOfDays = countCurrentMarks + countCurrentMarks;
        double maxAverageMark = (countCurrentMarks * this.averageMark + countRemainingMarks * 5) / totalCountOfDays;
        this.mayBeContinueTraining = maxAverageMark >= 4.5;
    }

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
