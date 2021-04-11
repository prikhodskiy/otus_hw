package ru.aprikhodskiy.otus;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import ru.aprikhodskiy.otus.service.ExamService;

@PropertySource("classpath:application.properties")
@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
        ExamService service = context.getBean(ExamService.class);
        service.runExam();
    }
}
