package com.example.api.repository;

import java.util.List;

import com.example.api.model.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie, String> {

    @Query(value = "SELECT * FROM movie WHERE winner = ?1 order by year", nativeQuery = true)
    List<Object[]> buscaPorGanhadores(String winner);
}
