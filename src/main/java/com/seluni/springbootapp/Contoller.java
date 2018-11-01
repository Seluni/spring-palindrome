package com.seluni.springbootapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import static com.seluni.springbootapp.DataStorage.*;

@RestController
public class Contoller {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/game")
    public User game(@RequestParam Map<String,String> requestParams) throws Exception {
        int points;
        String template;
        String user = requestParams.get("userName");
        String pal = requestParams.get("inputString");
        Long cou = counter.incrementAndGet();
        if (Palindrom.isPalindrome(pal)){
            points = pal.replaceAll("\\s+", "").length();
            template = "Поздравляем, это палиндром!";

            userPalindrome.put(user, a);

            ArrayList b = userPalindrome.get(user);
            if (b == null){
                userPalindrome.get(user).add(pal.replaceAll("\\s+", "").toLowerCase());
            }
            else if (b.contains(pal.replaceAll("\\s+", "").toLowerCase())){
                points = 0;
                template = "Вы уже предлагали такую фразу";
            }
            else {
                userPalindrome.get(user).add(pal.replaceAll("\\s+", "").toLowerCase());
            }

            Integer previousValue = userPoints.get(user);
            userPoints.put(user, previousValue == null ? points: previousValue + points);
            a.clear();
        }
        else {
            points = 0;
            template = "Попробуйте ещё";
        }

        return new User(cou, user, pal, points, template);
    }

    @RequestMapping(value="/leaders", method=RequestMethod.GET)
    public String[] showLeaders (Map<String, Integer> map){
        for (Map.Entry<String, Integer> entry : userPoints.entrySet()) {
            String ar[] = new String[2];
            ar[0] = entry.getKey();
            ar[1] = entry.getValue().toString();
            return ar;
        }
        return new String[0];
    }

}
