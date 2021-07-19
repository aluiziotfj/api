package com.example.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    @Id

    private String title;
    private String producers;
    private String studios;
    private String winner;
    private Integer year;

    public Movie() {
    }

    public Movie(String title, String producers, String studios, String winner, Integer year) {
        this.title = title;
        this.producers = producers;
        this.studios = studios;
        this.winner = winner;
        this.year = year;
    }

    public Movie(Object[] object) {
        this.title = object[0] != null ? object[0].toString() : null;
        this.producers = object[1] != null ? object[1].toString() : null;
        this.studios = object[2] != null ? object[2].toString() : null;
        this.winner = object[3] != null ? object[3].toString() : null;
        this.year = object[4] != null ? Integer.valueOf(object[4].toString()) : null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProducers() {
        return producers;
    }

    public void setProducers(String producers) {
        this.producers = producers;
    }

    public String getStudios() {
        return studios;
    }

    public void setStudios(String studios) {
        this.studios = studios;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

}
