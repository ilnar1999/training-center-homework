package com.example.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ParseService {

    private Map<String, String> data;
    private String[] expression;

    private static final String ERROR_KEY = "error";
    private static final String DEFAULT_ORDER = "time";
    private static final String DEFAULT_FILTER = "off";

    public Map<String, String> parseExpression(String[] expression) {
        this.expression = expression;
        this.data = new HashMap<>();
        switch (this.expression[0]) {
            case "show":
                this.data.put("action", "show");
                this.show();
                break;
            case "":
                this.data.put(ERROR_KEY, "������� ������ ������!");
                break;
            default:
                this.data.put(ERROR_KEY, "������������ ���������! ��� ������ ������� ������� \"exit\"!");
        }
        return this.data;
    }

    private void show() {
        if (this.expression.length < 2) {
            this.data.put(ERROR_KEY, "�� ������ ������ ��� �����������! ������: \"student lastname_firstname\" ��� \"students\"!");
            return;
        }
        switch (this.expression[1]) {
            case "student":
                this.data.put("object", "student");
                if (this.expression.length < 4) {
                    this.data.put(ERROR_KEY, "�� ������� ��� ��� ������� ��������! ������: \"Ivanov Ivan\"");
                    return;
                }
                this.data.put("fullName", this.parseName());
                break;
            case "students":
                this.data.put("object", "students");
                this.addOrder();
                this.addFilter();
                break;
            default:
                this.data.put(ERROR_KEY, "����������� ������ ������ ��� �����������! ������: \"student lastname_firstname\" ��� \"students\"!");
        }
    }

    private void addOrder() {
        String order = "order";
        for (String word : this.expression) {
            if (word.startsWith("order=")) {
                switch (word.replace("order=", "")) {
                    case "time":
                        this.data.put(order, "time");
                        return;
                    case "average":
                        this.data.put(order, "average");
                        return;
                    default:
                        this.data.put(ERROR_KEY, "����������� ������ ������ ����������! ������: \"order=time\" ��� \"order=average\"");
                        return;
                }
            }
        }
        this.data.put(order, DEFAULT_ORDER);
    }

    private void addFilter() {
        String filter = "filter";
        for (String word : this.expression) {
            if (word.startsWith("filter=")) {
                switch (word.replace("filter=", "")) {
                    case "may_continue":
                        this.data.put(filter, "may_continue");
                        return;
                    default:
                        this.data.put(ERROR_KEY, "����������� ������ ������! ������: \"filter=may_continue\"");
                        return;
                }
            }
        }
        this.data.put(filter, DEFAULT_FILTER);
    }

    private String parseName() {
        return expression[2] + " " + expression[3];
    }
}
