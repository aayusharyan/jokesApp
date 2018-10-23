package com.aayushsinha.jokesapplib.javalib;

import java.util.Random;

public class JavaLib {
    static String[] jokes = {
            "This is Joke 1",
            "This is a funny Joke #2",
            "This is a very funny Joke number 3",
            "This is superfunny Joke Number 4",
            "This is another Joke",
            "Ha Ha Ha",
            "OMG, This is soo funny",
            "This is soo funny, that this will definitely offend someone"
    };

    public static String tellJoke(){
        Random rndm = new Random();
        return jokes[rndm.nextInt(jokes.length)];
    }
}
