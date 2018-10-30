package com.seluni.springbootapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Contoller {

    private final AtomicLong counter = new AtomicLong();
    private final Map<String, String> userPalindrome = new HashMap<>();
    private final Map<String, Integer> userPoints = new HashMap<>();

    @RequestMapping("/game")
    public User game(@RequestParam Map<String,String> requestParams) throws Exception {
        int points;
        String template;
        String user = requestParams.get("userName");
        String pal = requestParams.get("inputString");
        Long cou = counter.incrementAndGet();
        if (Palindrom.isPalindrome(pal)){
            points = pal.replaceAll("\\s+", "").length();
            template = "Yes, its it";
            userPalindrome.put(user, pal);
            userPoints.put(user, points);
        }
        else {
            points = 0;
            template = "try another";
        }

        return new User(cou, user, pal, points, template);
    }

}
