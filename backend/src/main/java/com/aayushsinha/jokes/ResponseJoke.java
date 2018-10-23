package com.aayushsinha.jokes;

/**
 * The object model for the data we are sending through endpoints
 */
public class ResponseJoke {

    private String joke;

    public String getJoke() {
        return this.joke;
    }

    public void setJoke(String data) {
        this.joke = data;
    }
}
