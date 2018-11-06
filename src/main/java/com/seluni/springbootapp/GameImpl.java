package com.seluni.springbootapp;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameImpl implements Game{

    private final AtomicLong counter = new AtomicLong();

    private ArrayList<Player> players = new ArrayList<>();

    @Override
    public Stream <Map.Entry<String, Integer>> getLeaders() {

        players.sort(new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                return -1 * Integer.compare(p1.getPoints(), p2.getPoints());
                }
            });

        return players.stream().limit(LEADERS_COUNT).
                map(p -> new AbstractMap.SimpleEntry(p.getName(), p.getPoints()));
        }

    public Map<String,Integer> stream_to_map(){
        return getLeaders().collect(Collectors.toMap(e -> e.getKey(),
                e -> e.getValue()));
        }


    @Override
    public Player getOrCreatePlayer(String name) {

        for (Player player: players) {
            if (player.getName().equals(name))
                return player;
        }
        Player player = new Player(counter.incrementAndGet(), name);
        players.add(player);

        return player;
    }


    @Override
    public String playGame(String name, String pal) {

        Player player = getOrCreatePlayer(name);

        if (Palindrom.isPalindrome(pal))
            return player.addPalindrome(pal);
         else return "Попробуйте ещё";

    }


}
