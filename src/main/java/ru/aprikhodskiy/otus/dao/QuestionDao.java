package ru.aprikhodskiy.otus.dao;

import ru.aprikhodskiy.otus.domain.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> findAll();
}
