package com.example.algorithm.model;

public class SectionsModel {

    private String day;
    private int time;
    private int code;

    public SectionsModel() {
    }

    public SectionsModel(String day, int time, int code) {
        this.day = day;
        this.time = time;
        this.code = code;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
