package com.example;

import com.example.initialization.CourseInitializer;
import com.example.initialization.CurriculumInitializer;
import com.example.initialization.StudentInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);
        applicationContext.getBean("curriculumInitializer", CurriculumInitializer.class);
        applicationContext.getBean("courseInitializer", CourseInitializer.class);
        applicationContext.getBean("studentInitializer", StudentInitializer.class);
    }
}
