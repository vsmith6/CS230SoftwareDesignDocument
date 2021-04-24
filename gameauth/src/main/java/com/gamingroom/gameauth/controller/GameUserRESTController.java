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

package com.gamingroom.gameauth.controller;


import com.gamingroom.gameauth.controller.GameUserRESTController;
import com.gamingroom.gameauth.dao.GameUserDB;
import com.gamingroom.gameauth.representations.GameUserInfo;

import io.dropwizard.auth.Auth;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Set;
import java.net.URI;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.gamingroom.gameauth.authentication.GameUser;


/**
 * added the path annotation for gameusers
 * 
 * @author Valerie J. Smith
 * March 26, 2021
 *
 */
@Path ("/gameusers") //Defines URL path for gameusers
@Produces(MediaType.APPLICATION_JSON)
public class GameUserRESTController {
 
    private final Validator validator;
 
    public GameUserRESTController(Validator validator) {
        this.validator = validator;
    }
 
    @PermitAll
    @GET
    public Response getGameUsers(@Auth GameUser user) {
        return Response.ok(GameUserDB.getGameUsers()).build();
    }
 
  /**
   * added  RolesAllowed annotation for USER based on BasicAuth Security Example, removed the curly
   * braces on 4/1/2021
   * @author Valerie J. Smith
   * @param id
   * @param user
   * @return response
   */
    
    @RolesAllowed("USER") // Authenticates USER and allows API access to users with USER role 
    @GET
    @Path("/{id}")
    public Response getGameUserById(@PathParam("id") Integer id,@Auth GameUser user) {
    	//You can validate here if user is watching his record
    	/*if(id != user.getId()){
    			//Not allowed
    	}*/
        GameUserInfo gameUser = GameUserDB.getGameUser(id);
        if (gameUser != null)
            return Response.ok(gameUser).build();
        else
            return Response.status(Status.NOT_FOUND).build();
    }


  
    /**
     * added RolesAllowed annotation for ADMIN based on BasicAuth Security Example, removed
     * the curly braces on 4/1/2021 
     * @param gameUserInfo
     * @param user
     * @return response
     * @throws URISyntaxException
     */
    @RolesAllowed("ADMIN") // Authenticates ADMIN and allows API access to admin with ADMIN role
    @POST
    public Response createGameUser(GameUserInfo gameUserInfo, @Auth GameUser user) throws URISyntaxException {
        // validation
        Set<ConstraintViolation<GameUserInfo>> violations = validator.validate(gameUserInfo);
        GameUserInfo e = GameUserDB.getGameUser(gameUserInfo.getId());
        if (violations.size() > 0) {
            ArrayList<String> validationMessages = new ArrayList<String>();
            for (ConstraintViolation<GameUserInfo> violation : violations) {
                validationMessages.add(violation.getPropertyPath().toString() + ": " + violation.getMessage());
            }
            return Response.status(Status.BAD_REQUEST).entity(validationMessages).build();
        }
        if (e != null) {
            GameUserDB.updateGameUser(gameUserInfo.getId(), gameUserInfo);
            return Response.created(new URI("/gameusers/" + gameUserInfo.getId()))
                    .build();
        } else
            return Response.status(Status.NOT_FOUND).build();
    }
 
    @PUT
    @Path("/{id}")
    public Response updateGameUserById(@PathParam("id") Integer id, GameUserInfo gameUserInfo) {
        // validation
        Set<ConstraintViolation<GameUserInfo>> violations = validator.validate(gameUserInfo);
        GameUserInfo e = GameUserDB.getGameUser(gameUserInfo.getId());
        if (violations.size() > 0) {
            ArrayList<String> validationMessages = new ArrayList<String>();
            for (ConstraintViolation<GameUserInfo> violation : violations) {
                validationMessages.add(violation.getPropertyPath().toString() + ": " + violation.getMessage());
            }
            return Response.status(Status.BAD_REQUEST).entity(validationMessages).build();
        }
        if (e != null) {
            gameUserInfo.setId(id);
            GameUserDB.updateGameUser(id, gameUserInfo);
            return Response.ok(gameUserInfo).build();
        } else
            return Response.status(Status.NOT_FOUND).build();
    }
 
    @DELETE
    @Path("/{id}")
    public Response removeGameUserById(@PathParam("id") Integer id) {
        GameUserInfo gameUser = GameUserDB.getGameUser(id);
        if (gameUser != null) {
            GameUserDB.removeGameUser(id);
            return Response.ok().build();
        } else
            return Response.status(Status.NOT_FOUND).build();
    }

}
