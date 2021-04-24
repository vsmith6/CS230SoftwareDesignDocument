/*
 * Valerie J. Smith
 * Gaming Room Authentication Example
 * March 20, 2021
 * CS-230-H4756 Operating Platforms 21EW4
 * Mod 4 Assignment 1
 * Dr.Lyon
 * 
 * 
 * */

package com.gamingroom.gameauth.authentication;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
 
import java.util.Map;
import java.util.Optional;
import java.util.Set;
 
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

public class GameAuthenticator implements Authenticator<BasicCredentials, GameUser> 
{
    private static final Map<String, Set<String>> VALID_USERS = ImmutableMap.of(
        "guest", ImmutableSet.of(),
        "user", ImmutableSet.of("USER"),
        /**
         * Add a player with the role of "Player"
         * @author vsmith6
         * April 2, 2021
         */
        "player",ImmutableSet.of("PLAYER"),
        "admin", ImmutableSet.of("ADMIN", "USER")
    );
 
    @Override
    public Optional<GameUser> authenticate(BasicCredentials credentials) throws AuthenticationException 
    {
        if (VALID_USERS.containsKey(credentials.getUsername()) && "password".equals(credentials.getPassword())) 
        {
        	/**
        	 * completed the function by specifying a return type of GameUser and that the game users are valid
        	 * and is logged in with valid credentials
        	 * @author Valerie J. Smith
        	 * March 26, 20201
        	 * @return Game User credentials, valid users
        	 */
            return Optional.of(new GameUser(credentials.getUsername(), VALID_USERS.get(credentials.getUsername())));
        }
        return Optional.empty();
    }
}