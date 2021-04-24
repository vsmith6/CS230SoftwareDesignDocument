/*
 * Valerie J. Smith
 * Gaming Room Program
 * March 21, 2021
 * CS-230-H4756 Operating Platforms 21EW4
 * Project 1
 * Dr.Lyon
 * 
 * This class is the entry class for the Gaming room program and contains the main method. This class initialized
 * the game service class and calls the singleton class for and instance of the game. This class features a
 * singleton tester, which is provided to prove that there is only one instance of the game class that was created*/
package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author coce@snhu.edu
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
	    /* create a reference to an instance of the Game Service
	     * and store it in an object named service. This will return
	     * the instance of the game to ensure that there is only one game
	     * in memory at any time.
	     * */
	     
		GameService gameService = GameService.getInstance(); 
		
		System.out.println("\nAbout to test initializing game data...");
		
		// initialize with some game data
		Game game1 = gameService.addGame("Game #1");
		System.out.println(game1);
		Game game2 = gameService.addGame("Game #2");
		System.out.println(game2);
		
		// testing that the game service will create a unique id
		long newTeam = gameService.getNextTeamId();
		long newTeam2 = gameService.getNextTeamId();
		long newPlayerId = gameService.getNextPlayerId();
		long newPlayerId2 = gameService.getNextPlayerId();
		System.out.println(newTeam + "  "+ newTeam2);
		
		// testing that a new team can be created with id and name
	    Team team1 = new Team(newTeam, "Thor");
	    System.out.println(team1);
	    Team team2 = new Team(newTeam2, "Loki");
	    System.out.println(team2);
		
	    // testing that the singleton will not create another game 1
		Game game3 = gameService.addGame("Game #1");
		
		// testing that new players can be created with id and name
		Player newPlayer1 = new Player(newPlayerId, "Gamora");
		Player newPlayer2 = new Player(newPlayerId2, "Groot");
		System.out.println("new players: "+ newPlayer1 + "  " + newPlayer2);
		
		
		// testing that the game will add a team named "Avengers"
		Game game4 = gameService.addGame("Game 4");
		
		System.out.println(game4.addTeam("Avengers"));
		
		

	
		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
	}
}
