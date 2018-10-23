package com.aayushsinha.jokes;

import java.util.Random;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokesLib",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.jokesapp.aayushsinha.com",
                ownerName = "backend.jokesapp.aayushsinha.com",
                packagePath = ""
        )
)


public class JokesLib {

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

    @ApiMethod(name = "tellJoke")
    public ResponseJoke tellJoke() {
        Random rndm = new Random();
        ResponseJoke res = new ResponseJoke();
        res.setJoke(jokes[rndm.nextInt(jokes.length)]);
        return res;
    }

}
