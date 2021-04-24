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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity{



    // add private ArrayList named players as per UML diagram
	private List<Player> players = new ArrayList<Player>();
	
	/*
	 * Constructor with an identifier and name, name and id are added from super class Entity
	 * to satisfy requirement of UML diagram for Project 1
	 */
	public Team(long id, String name) {
		super(id,name);

	}
	
	/*
	 * Project 1 adding the addPlayer method that takes a parameter of String name. Java iterator
	 * will loop throught the players list. If the player is found, it is not added to the list. If the player
	 * is not found by name, it is added to the list of players.*/
	
	public Player addPlayer(String name) {
	    Player player = null;
		Player tempPlayer = null;
		Iterator<Player> playerIterator = players.iterator();
		while (playerIterator.hasNext()) {
			tempPlayer = playerIterator.next();
			if (tempPlayer.getName().equalsIgnoreCase(name)) {
				return tempPlayer;
			}
		}
		if (player == null) {
		//  using 1 as a placeholder for the creation of the new player until further instructions are provided.
			player = new Player(1, name);
			players.add(player);

		}

		return player;
	}

   // requirement for Project 1, adding toString method with only the id and the name
	
	@Override
	public String toString() {
		return "Team [id = " + getId() + ", name = " + getName()  + "]";
	}

}
