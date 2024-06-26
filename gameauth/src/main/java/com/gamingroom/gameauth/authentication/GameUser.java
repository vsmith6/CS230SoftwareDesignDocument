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

import java.security.Principal;
import java.util.Set;





public class GameUser implements Principal{
	
	private String name = "";
	
	private final Set<String> roles;
	
	public GameUser(String name) {
		this.name = name;
		this.roles = null;
	}
	
	public GameUser(String name, Set<String> roles) {
		this.name = name;
		this.roles = roles;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return (int) (Math.random() * 100);
	}
	
	public Set<String> getRoles() {
		return roles;
	}
	
}