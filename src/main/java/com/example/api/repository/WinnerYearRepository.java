package com.example.api.repository;

import java.util.Collection;
import java.util.List;

import com.example.api.model.WinnerYear;
import com.example.api.model.dto.MovieDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WinnerYearRepository extends JpaRepository<WinnerYear, String> {

        @Query(value = "select producer, (max(ano) - min(ano)) as period,  min(ano) as previousWin, max(ano) as followingWin from ( \n"
                        + "SELECT producer, year_winner as ano FROM WINNER_YEAR  order by producer, year_winner ) tb \n"
                        + "group by producer  having period > 0 order by period asc limit 1", nativeQuery = true)
        List<Object[]> buscaMenorPeriodo();

        @Query(value = "select producer, (max(ano) - min(ano)) as period,  min(ano) as previousWin, max(ano) as followingWin from ( \n"
                        + "SELECT producer, year_winner as ano FROM WINNER_YEAR  order by producer, year_winner ) tb \n"
                        + "group by producer  having period > 0 order by period desc limit 1", nativeQuery = true)
        List<Object[]> buscaMaiorPeriodo();

}
