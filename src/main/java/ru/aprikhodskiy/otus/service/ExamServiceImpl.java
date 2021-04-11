package ru.aprikhodskiy.otus.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.aprikhodskiy.otus.dao.QuestionDao;
import ru.aprikhodskiy.otus.domain.Question;
import ru.aprikhodskiy.otus.domain.Student;
import ru.aprikhodskiy.otus.exception.ReadQuestionsException;

import java.io.IOException;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    private final QuestionDao dao;

    int correctAnswersCounter = 0;

    private Student student;
    private final UserInput userInput;

    @Value("${pass-rate}")
    private String passRate = "0";

    public ExamServiceImpl(QuestionDao dao, UserInput userInput) {
        this.dao = dao;
        this.userInput = userInput;
    }

    @Override
    public List<Question> getAllQuestions() {
        try {
            return dao.findAll();
        } catch (ReadQuestionsException e) {
            System.out.println("Read questions exception:" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void runExam() {
        askForName();
        for (Question q :
                dao.findAll()) {
            if (checkAnswer(q))
                correctAnswersCounter++;
            System.out.println("===============================================");
        }
        printResults();
    }

    private void askForName() {
        System.out.println("Enter your name: ");
        try {
            this.student = new Student(userInput.getName());
        } catch (IOException e) {
            System.out.println("Sorry. Something went wrong: " + e.getMessage());
        }
    }

    private boolean checkAnswer(Question question) {
        System.out.println();
        System.out.println("+++++++++++++++ Question №: " + question.getOrder() + " ++++++++++++++++");
        System.out.println(question.getText());

        try {
            String studentAnswer = userInput.getAnswer();
            return studentAnswer.equals(question.getAnswer());
        } catch (IOException e) {
            System.out.println("Sorry. Something went wrong: " + e.getMessage());
            return false;
        }
    }

    private void printResults() {
        System.out.println();
        System.out.println(student.getName() + ", you have correctly answered for " + correctAnswersCounter
                + " question" + (correctAnswersCounter > 1 ? "s" : ""));
        if (correctAnswersCounter >= Integer.parseInt(passRate))
            System.out.println("Congratulations! You passed the exam");
        else
            System.out.println("Sorry, " + student.getName() + ", but you failed the exam");
    }
}
