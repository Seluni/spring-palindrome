package com.seluni.springbootapp;

import java.util.Map;
import java.util.stream.Stream;

public interface Game {

    int LEADERS_COUNT = 5;
     Stream<Map.Entry<String, Integer>> getLeaders();
     String playGame(String player, String pal);
     Map<String,Integer> stream_to_map();

    Player getOrCreatePlayer(String name);

}
