package com.example.api.model.dto;

import org.springframework.beans.factory.annotation.Autowired;

public class WinnerDTO {

    private String title;

    @Autowired
    private MovieDTO movie;

    public WinnerDTO() {
    }

    public WinnerDTO(String title, MovieDTO movie) {
        this.title = title;
        this.movie = movie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MovieDTO getMovie() {
        return movie;
    }

    public void setMovie(MovieDTO movie) {
        this.movie = movie;
    }

}
