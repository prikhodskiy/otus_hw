package ru.aprikhodskiy.otus.dao;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import ru.aprikhodskiy.otus.domain.Question;

import java.util.Collections;
import java.util.List;

@Component
public class QuestionDaoImpl implements QuestionDao {
    @Value("${questions.file.name}")
    Resource resourceFile;

    @Override
    public List<Question> findAll() {
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            ObjectReader reader = mapper.readerFor(Question.class).with(bootstrapSchema);
            MappingIterator<Question> readValues = reader.readValues(resourceFile.getInputStream());

            return readValues.readAll();

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
