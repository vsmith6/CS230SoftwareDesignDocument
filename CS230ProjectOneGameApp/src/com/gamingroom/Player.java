/*
 * Valerie J. Smith
 * Gaming Room Program
 * March 21, 2021
 * CS-230-H4756 Operating Platforms 21EW4
 * Project 1
 * Dr.Lyon
 * 
 * 
 * */
package com.gamingroom;

/**
 * A simple class to hold information about a player
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a player is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */

// Player extends Entity, requirement for Project 1
public class Player extends Entity {
	
	/*
	 * Constructor with an identifier and name, name and id are added from super class Entity
	 * to satisfy requirement of UML diagram for Project 1
	 */
	public Player(long id, String name) {
		super(id, name);
	
	}
	
	// Project One requirement, add to string function, adding with only id and name

	@Override
	public String toString() {
		return "Player [id = " + getId() + ", name = " + getName()+ "]";
	}



}
