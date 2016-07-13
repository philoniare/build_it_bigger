/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.philoniare.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import joker.Joker;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokerApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.philoniare.example.com",
                ownerName = "backend.myapplication.philoniare.example.com",
                packagePath = ""
        )
)
public class JokerEndpoint {

  /**
   * A simple endpoint method that supplies a joke from the Joker Java Lib
   */
  @ApiMethod(name = "fetchJoke")
  public Joke fetchJoke() {
    Joke response = new Joke();
    response.setData(Joker.joke());
    return response;
  }
}
