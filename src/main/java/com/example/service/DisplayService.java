package com.example.service;

import com.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DisplayService {

    @Autowired
    private StudentService studentService;

    private Map<String, String> data;

    public void print(Map<String, String> data) {
        this.data = data;
        if (data.containsKey("error")) {
            System.out.println(this.data.get("error"));
            return;
        }
        switch (data.get("action")) {
            case "show":
                this.show();
                break;
            default:
                System.out.println("����������� ������!");
        }
    }

    public void show() {
        switch (this.data.get("object")) {
            case "student":
                this.showStudent();
                break;
            case "students":
                this.showStudents();
                break;
        }
    }

    public void showStudent() {
        Student student = studentService.getByFullName(this.data.get("fullName"));
        String statusOfStudy;
        if (student == null) {
            System.out.println("������ �� ������!");
            return;
        }
        statusOfStudy = student.isMayBeContinueTraining() ? "����� ���������� ��������" : "���������";
        System.out.printf(
                "%s - �� ��������� �������� �� ��������� %s �������� %d �. ������� ���� %.2f. %s.%n",
                student.getFullName(),
                student.getCurriculum().getTitle(),
                student.getCountOfDaysUntilFinishCurriculum(),
                student.getAverageMark(),
                statusOfStudy
        );

    }

    public void showStudents() {
        String order = this.data.get("order");
        String filter = this.data.get("filter");
        String statusOfStudy;
        List<Student> students = this.studentService.getStudents(order, filter);

        for (Student student : students) {
            statusOfStudy = student.isMayBeContinueTraining() ? "����� ���������� ��������" : "���������";
            System.out.printf(
                    "%s - �� ��������� �������� �� ��������� %s �������� %d �. ������� ���� %.2f. %s.%n",
                    student.getFullName(),
                    student.getCurriculum().getTitle(),
                    student.getCountOfDaysUntilFinishCurriculum(),
                    student.getAverageMark(),
                    statusOfStudy
            );
        }
    }
}
