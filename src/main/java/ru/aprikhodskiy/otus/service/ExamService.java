package ru.aprikhodskiy.otus.service;

import ru.aprikhodskiy.otus.domain.Question;

import java.util.List;

public interface ExamService {
    List<Question> getAllQuestions();

    void runExam();
}
