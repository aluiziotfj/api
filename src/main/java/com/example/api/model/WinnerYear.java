package com.example.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WinnerYear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String producer;
    private Integer yearWinner;

    public WinnerYear() {
    }

    public WinnerYear(Integer id, String producer, Integer yearWinner) {
        this.id = id;
        this.producer = producer;
        this.yearWinner = yearWinner;
    }

    public WinnerYear(String producer, Integer yearWinner) {
        this.producer = producer;
        this.yearWinner = yearWinner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Integer getYearWinner() {
        return yearWinner;
    }

    public void setYearWinner(Integer yearWinner) {
        this.yearWinner = yearWinner;
    }

    @Override
    public String toString() {
        return "WinnerYear [id=" + id + ", producer=" + producer + ", yearWinner=" + yearWinner + "]";
    }

}
