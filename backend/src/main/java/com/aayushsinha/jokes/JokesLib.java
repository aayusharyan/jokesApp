package com.aayushsinha.jokes;

import java.util.Random;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.aayushsinha.jokesapplib.javalib;

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

    @ApiMethod(name = "tellJoke")
    public ResponseJoke tellJoke() {
        ResponseJoke res = new ResponseJoke();
        res.setJoke(JavaLib.tellJoke());
        return res;
    }

}
