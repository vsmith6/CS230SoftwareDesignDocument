/**
 * A simple class to hold information about an entity
 * 
 * Valerie J. Smith
 * Gaming Room Program
 * March 20, 2021
 * CS-230-H4756 Operating Platforms 21EW4
 * Project 1
 * Dr.Lyon
 * 
 */
package com.gamingroom;

public class Entity {
	private long id;
	private String name;

	// declare private default constructor
	private Entity() {

	}

	// declare overloaded public constructor with an identifier and name
	public Entity(long id, String name) {
		this();
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id
	 */

	// create getter method for id
	public long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	// create getter method for name
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + "]";
	}



}
