package ru.aprikhodskiy.otus.domain;

public class Question {
    private String text;
    private Integer order;
    private String answer;

    public void setText(String text) {
        this.text = text;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public String getText() {
        return text;
    }

    public Integer getOrder() {
        return order;
    }

    public String getAnswer() {
        return answer;
    }

    public Question() {
    }

    public Question(Integer order, String text, String answer) {
        this.text = text;
        this.order = order;
        this.answer = answer;
    }
}
