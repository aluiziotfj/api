package com.example.api.config;

import java.io.File;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.api.model.Movie;
import com.example.api.repository.MovieRepository;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class Setup {

    @Autowired
    MovieRepository movieRepository;

    public <T> List<T> loadObjectList(Class<T> type, String fileName) {
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader().withColumnSeparator(';');
            CsvMapper mapper = new CsvMapper();
            File file = new ClassPathResource(fileName).getFile();
            MappingIterator<T> readValues = mapper.reader(type).with(bootstrapSchema).readValues(file);

            return readValues.readAll();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

    }

    @PostConstruct
    private void setupData() {
        List<Movie> movies = loadObjectList(Movie.class, "assests/movielist.csv");
        movieRepository.saveAll(movies);
    }
}
