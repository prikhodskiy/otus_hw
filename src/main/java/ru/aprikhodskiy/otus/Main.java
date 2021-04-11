package ru.aprikhodskiy.otus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import ru.aprikhodskiy.otus.service.ExamService;

@PropertySource("classpath:application.properties")
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        ExamService service = context.getBean(ExamService.class);
        service.runExam();
    }
}
