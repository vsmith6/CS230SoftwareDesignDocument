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


import io.dropwizard.auth.Authorizer;

public class GameAuthorizer implements Authorizer<GameUser> 
{
    @Override
    public boolean authorize(GameUser user, String role) {
    	/**
    	 * return the user roles that are not null and if the user roles
    	 * that contain the roles that are set in the GameUser class, return true.
    	 * 
    	 * @author Valerie J. Smith
    	 * March 26, 2021
    	 * @return user.getRoles, user.getRoles().contains(role)
    	 */
        return user.getRoles() != null && user.getRoles().contains(role);
    }
}