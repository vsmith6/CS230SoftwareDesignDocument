/*
 * /*
 * Valerie J. Smith
 * Gaming Room Program
 * March 21, 2021
 * CS-230-H4756 Operating Platforms 21EW4
 * Project 1
 * Dr.Lyon
 * 
 * 
 * 
 * Game Service Class 
 * This singleton class is created in order to provide storage for a list of games for the Gaming Room program.
 * An array list of games is created along with a nexdtGameId integer. A private static object instance is created
 * in order to ensure that there is only one instance of the game. A private constructor ensures that the GameService
 * class cannot be instantiated. The addGame method uses and advanced for loop as an iterator in order to
 * store the next game id and name.
 * The accessor functions feature three overloaded methods that will return the game by index, by id, or by name. The enhanced 
 * for loop is utilized as an iterator to search for the game by name or id in the respective method  */

package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	/*
	 * holds the next player id identifier, initialized as 1 until further
	 * instructions are noted and to remain consistent with existing code.
	 */

	private static long nextPlayerId = 1;

	/* holds the next team id identifier, initialized as 1 until further 
	 * instructions are noted and to remain consistent with existing code */

	private static long nextTeamId = 1;

	/*
	 * create a private object of GameService along with a static modifier in order
	 * to make the GameService class a singleton class
	 */

	private static GameService service = new GameService();

	/*
	 * set a private constructor for the game service instance so that this class
	 * cannot be instantiated - also is an indicator of a Singleton class
	 */
	private void GameService() {

	}

	/*
	 * get the only object that is available of the Game Service Singleton class
	 */

	// adding feedback supposedly 'lazy' instantiation
	public static GameService getInstance() {
		if (service == null) {
			service = new GameService();
		}
		return service;
	}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */

	/*
	 * This function is using the java Iterator as in order to loop through the
	 * array list of games as the list contains multiple attributes if the id is
	 * found, return the id of the instance that is already created and assign it to
	 * the local instance
	 */

	public Game addGame(String name) {
		Game game = null;
		Game tempGame = null;
	
		Iterator<Game> gamesIterator = games.iterator();
		while (gamesIterator.hasNext()) {
			tempGame = gamesIterator.next();
			if (tempGame.getName().equalsIgnoreCase(name)) {
				return tempGame;
			}
		}
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);		
		
		}
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * 
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}

	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		/*
		 * This function is using the java Iterator as in order to loop through the
		 * array list of games as the list contains multiple attributes if the id is
		 * found, return the id of the instance that is already created and assign it to
		 * the local instance
		 */

		Game tempGame = null;
		Iterator<Game> gamesIterator = games.iterator();
		while (gamesIterator.hasNext()) {
			tempGame = gamesIterator.next();
			if (tempGame.getId() == id) {
				return tempGame;
			}
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		/*
		 * This function is using the Java iterator in order to loop through the array
		 * list of games as the list contains multiple attributes if the name is found,
		 * return the name of the game that is already created and assign it to the
		 * local variable
		 */

		Game tempGame = null;
		Iterator<Game> gamesIterator = games.iterator();
		while (gamesIterator.hasNext()) {
			tempGame = gamesIterator.next();
			if (tempGame.getName().equalsIgnoreCase(name)) {
				return tempGame;
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	/* get method to return the nextPlayerId, requirement from UML document for Project 1.
	 * Must return a long, assigning nextPlayerId with an incrementor as the return until further
	 * instructions are provided.
	 * */
	 

	public long getNextPlayerId() {
		return nextPlayerId++;

	}

	/* get method to return the nextTeamId, requirement from UML document for Project 1. Method
	 * must return a long, assigning nextTeamId with an incrementor as the return until further
	 * instructions are provided. 
	 */
	

	public long getNextTeamId() {
		return nextTeamId++;

	}

}
