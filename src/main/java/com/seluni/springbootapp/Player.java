package com.seluni.springbootapp;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jdk.nashorn.internal.ir.ObjectNode;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

public class Player {

    private final long id;
    private final String name;
    private int points;

    private ArrayList<String> palindroms;

    public Player(long id, String name){
        this.id=id;
        this.name =name;
        this.points = 0;
        this.palindroms =new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public int getPoints() {
        return points;
    }

    public String addPalindrome(String p){
        if (!hasPalindrome(p)){
            palindroms.add(p);
            points += Palindrom.getPoints(p);
            return "Да, " + p + " является палиндромом и добавлен к Вашему списку";
        }
        else {
            return "Вы уже предлагали " + p + " ранее";
        }
    }

    private boolean hasPalindrome(String p){
        return palindroms.contains(p);
    }

}
