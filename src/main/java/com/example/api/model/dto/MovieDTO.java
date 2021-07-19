package com.example.api.model.dto;

public class MovieDTO {

    private String producer;
    private Integer interval;
    private Integer previousWin;
    private Integer followingWin;

    public MovieDTO() {
    }

    public MovieDTO(String producer, Integer interval, Integer previousWin, Integer followingWin) {
        this.producer = producer;
        this.interval = interval;
        this.previousWin = previousWin;
        this.followingWin = followingWin;
    }

    public MovieDTO(Object[] object) {
        this.producer = object[0] != null ? object[0].toString() : null;
        this.interval = object[1] != null ? Integer.valueOf(object[1].toString()) : null;
        this.previousWin = object[2] != null ? Integer.valueOf(object[2].toString()) : null;
        this.followingWin = object[3] != null ? Integer.valueOf(object[3].toString()) : null;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Integer getPreviousWin() {
        return previousWin;
    }

    public void setPreviousWin(Integer previousWin) {
        this.previousWin = previousWin;
    }

    public Integer getFollowingWin() {
        return followingWin;
    }

    public void setFollowingWin(Integer followingWin) {
        this.followingWin = followingWin;
    }

}
