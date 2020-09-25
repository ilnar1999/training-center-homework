package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Scanner;

@Service
public class ListenService {

    @Autowired
    private DisplayService displayService;
    @Autowired
    private ParseService parseService;

    @PostConstruct
    public void run() {
        String[] exception;
        Scanner scanner;
        Map<String, String> data;

        while (true) {
            scanner = new Scanner(System.in);
            exception = scanner.nextLine().split(" ");
            if (exception[0].equals("exit")) {
                System.exit(0);
            }
            data = this.parseService.parseExpression(exception);
            this.displayService.print(data);
            break;
        }
    }
}
