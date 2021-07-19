package com.example.api.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.example.api.model.Movie;
import com.example.api.model.WinnerYear;
import com.example.api.model.dto.MovieDTO;
import com.example.api.model.dto.WinnerDTO;
import com.example.api.repository.MovieRepository;
import com.example.api.repository.WinnerYearRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private WinnerYearRepository winnerYearRepository;

    public List<WinnerDTO> obterIntervalo() {

        List<Object[]> objects = movieRepository.buscaPorGanhadores("yes");

        List<WinnerYear> winners = new ArrayList<>();
        List<Movie> movies = objects.stream().map(Movie::new).filter(obj -> {
            System.out.println(obj.getProducers());
            // if (obj.getProducers().contains(", ") || obj.getProducers().contains(" and
            // ")) {
            if (obj.getProducers().contains(" and ")) {
                String[] list = (obj.getProducers()).split(" and ");

                WinnerYear wYear = new WinnerYear();
                wYear.setProducer(list[1]);
                wYear.setYearWinner(obj.getYear());
                winners.add(wYear);

                String[] list1 = list[0].split(", ");
                if (list1.length > 0) {
                    for (String prd : list1) {
                        WinnerYear wYear1 = new WinnerYear();
                        wYear1.setProducer(prd);
                        wYear1.setYearWinner(obj.getYear());
                        winners.add(wYear1);
                    }

                }
            } else {
                WinnerYear wYear = new WinnerYear();
                wYear.setProducer(obj.getProducers());
                wYear.setYearWinner(obj.getYear());
                winners.add(wYear);
            }

            return true;
        }).collect(Collectors.toList());

        winnerYearRepository.saveAll(winners);

        List<WinnerDTO> listWinner = new ArrayList<>();

        WinnerDTO wMin = new WinnerDTO();
        wMin.setTitle("min");

        List<Object[]> objMin = winnerYearRepository.buscaMenorPeriodo();
        List<MovieDTO> movieMin = objMin.stream().map(MovieDTO::new).collect(Collectors.toList());

        wMin.setMovie(movieMin.get(0));
        listWinner.add(wMin);

        WinnerDTO wMax = new WinnerDTO();
        wMax.setTitle("max");

        List<Object[]> objMax = winnerYearRepository.buscaMaiorPeriodo();
        List<MovieDTO> movieMax = objMax.stream().map(MovieDTO::new).collect(Collectors.toList());

        wMax.setMovie(movieMax.get(0));
        listWinner.add(wMax);

        return listWinner;
    }

}
