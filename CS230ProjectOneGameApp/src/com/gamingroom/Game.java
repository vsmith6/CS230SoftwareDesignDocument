/*
 * Valerie J. Smith
 * Gaming Room Program
 * March 20, 2021
 * CS-230-H4756 Operating Platforms 21EW4
 * Project 1
 * Dr.Lyon
 * 
 * 
 * */
package com.gamingroom;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {
	
//  add private array list of teams created from the Team object, Project One requirement from UML diagram
	private List<Team> teams = new ArrayList<Team>();
	
	
	

	/*
	 * Constructor with an identifier and name, name and id are added from super class Entity
	 * to satisfy requirement of UML diagram for Project 1
	 */
	public Game(long id, String name) {
	    super(id, name);
		
	}
	
	
	/*public method addTeam takes a parameter of String name and features the Java Iterator
	 * function to loop through the list of teams and check for an existing name. If the name is not found,
	 * it gets added to the Array List of players.
	 * */
	public Team addTeam(String name) {
	    Team team = null;
		Team tempTeam = null;
		Iterator<Team> teamsIterator = teams.iterator();
		while (teamsIterator.hasNext()) {
			tempTeam = teamsIterator.next();
			if (tempTeam.getName().equalsIgnoreCase(name)) {
				return tempTeam;
			}
		}
		if (team == null) {
			//  using 1 as a placeholder for the creation of the new team until further instructions are provided.
			team = new Team(1, name);
			teams.add(team);

		}
		return team;
	}
  
	// adding to string method as project 1 requirement, adding the id and name only

	@Override
	public String toString() {
		return "Game [id = " + getId() + ", name = " + getName()  + "]";
	}



}
