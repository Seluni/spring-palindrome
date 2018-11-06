package com.seluni.springbootapp;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;

import java.io.StringWriter;
import java.util.Map;

@RestController
public class Contoller {


    private final Game game = new GameImpl();

    @RequestMapping("/game")
    public String game(@RequestParam Map<String,String> requestParams) throws Exception {
        String name = requestParams.get("userName");
        String pal = requestParams.get("inputString");

        return game.playGame(name, pal);
    }
    @RequestMapping(value="/leaders", method=RequestMethod.GET)
    public @ResponseBody String leaders(){
        return game.stream_to_map().toString();
    }
}