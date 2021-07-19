package com.example.api.controller;

import java.util.List;

import com.example.api.model.dto.MovieDTO;
import com.example.api.model.dto.WinnerDTO;
import com.example.api.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @RequestMapping(value = "/getWinnerInterval", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<WinnerDTO>> obterIntervalo() {

        List<WinnerDTO> movieList = movieService.obterIntervalo();

        return ResponseEntity.ok().body(movieList);
    }

}
