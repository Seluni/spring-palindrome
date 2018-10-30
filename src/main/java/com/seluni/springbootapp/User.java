package com.seluni.springbootapp;

import org.springframework.lang.Nullable;

public class User {

    private final long id;
    private final String profile;
    private final String inputData;
    private final int points;
    private final String message;


    public User(long id, String profile, String inputData, int points, String message){
        this.id=id;
        this.profile=profile;
        this.inputData=inputData;
        this.points=points;
        this.message=message;
    }

    public long getId() {
        return id;
    }

    public String getProfile() {
        return profile;
    }

    public String getInputData() {
        return inputData;
    }

    public int getPoints() {
        return points;
    }

    public String getMessage() {
        return message;
    }
}
