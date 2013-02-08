package com.jacad.footapp.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * The Class Team.
 */
public class Team{

	/** The id. */
	private Integer id;
	
	/** The name. */
	private String name;
	
	/** The colors. */
	private String colors;
	
	/** The stadium name. */
	private String stadiumName;
	
	/** The creation year. */
	private Integer creationYear;
	
	/** The players. */
	private Set<Player> players;

	/**
	 * Instantiates a new team.
	 */
	public Team() {
		super();
		this.players = new HashSet<>();
	}

	/**
	 * Instantiates a new team.
	 *
	 * @param name the name
	 * @param colors the colors
	 * @param stadiumName the stadium name
	 * @param creationYear the creation year
	 * @param players the players
	 */
	public Team(String name, String colors, String stadiumName,
			Integer creationYear, Set<Player> players) {
		super();
		this.name = name;
		this.colors = colors;
		this.stadiumName = stadiumName;
		this.creationYear = creationYear;
		this.players = players;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the colors.
	 *
	 * @return the colors
	 */
	public String getColors() {
		return colors;
	}

	/**
	 * Sets the colors.
	 *
	 * @param colors the new colors
	 */
	public void setColors(String colors) {
		this.colors = colors;
	}

	/**
	 * Gets the stadium name.
	 *
	 * @return the stadium name
	 */
	public String getStadiumName() {
		return stadiumName;
	}

	/**
	 * Sets the stadium name.
	 *
	 * @param stadiumName the new stadium name
	 */
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

	/**
	 * Gets the creation year.
	 *
	 * @return the creation year
	 */
	public Integer getCreationYear() {
		return creationYear;
	}

	/**
	 * Sets the creation year.
	 *
	 * @param creationYear the new creation year
	 */
	public void setCreationYear(Integer creationYear) {
		this.creationYear = creationYear;
	}

	/**
	 * Gets the players.
	 *
	 * @return the players
	 */
	public Set<Player> getPlayers() {
		return players;
	}

	/**
	 * Sets the players.
	 *
	 * @param players the new players
	 */
	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
	
	/**
	 * Adds the player.
	 *
	 * @param player the player
	 */
	public void addPlayer(Player player) {
		this.players.add(player);
	}
	
	/**
	 * Removes the player.
	 *
	 * @param player the player
	 */
	public void removePlayer(Player player) {
		this.players.remove(player);
	}

}
