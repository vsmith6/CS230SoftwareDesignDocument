/*
 * 
 * Valerie J. Smith
 * Gaming Room Program
 * March 21, 2021
 * CS-230-H4756 Operating Platforms 21EW4
 * Project 1
 * Dr.Lyon
 * 
 * This class is a testing class that tests the singleton GameService class. It will create an
 * instance of the GameService and list the size of the number of games that are stored in the list*/
package com.gamingroom;

/**
 * A class to test a singleton's behavior
 * 
 * @author coce@snhu.edu
 */
public class SingletonTester {

	public void testSingleton() {
		
		System.out.println("\nAbout to test the singleton...");
		
        /* get the instance of game service and store in object service
         * in order to test the singleton service.  This will return the instance
         * of the game to ensure that there is only one game in memory*/
		GameService service = GameService.getInstance();
		
		// a simple for loop to print the games
		for (int i = 0; i < service.getGameCount(); i++) {
			System.out.println(service.getGame(i));
		
		}

	}
	
}
