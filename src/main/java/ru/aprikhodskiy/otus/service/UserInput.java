package ru.aprikhodskiy.otus.service;

import java.io.IOException;

public interface UserInput {
    String getName() throws IOException;
    String getAnswer() throws IOException;
}
