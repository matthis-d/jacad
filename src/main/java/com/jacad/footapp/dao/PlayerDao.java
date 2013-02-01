package com.jacad.footapp.dao;

import java.util.Collection;

import com.jacad.footapp.domain.Player;

/**
 * The Interface PlayerDao.
 */
public interface PlayerDao {
	
	/**
	 * Gets the player by id.
	 *
	 * @param id the id
	 * @return the player by id
	 */
	public Player getPlayerById(Integer id);
	
	/**
	 * Gets the all players.
	 *
	 * @return the all players
	 */
	public Collection<Player> getAllPlayers();
	
	/**
	 * Removes the player.
	 *
	 * @param id the id
	 */
	public void removePlayer(Integer id);
	
	/**
	 * Adds the player.
	 *
	 * @param player the player
	 */
	public void addPlayer(Player player);
	
	/**
	 * Updates player.
	 *
	 * @param player the player
	 */
	public void updatePlayer(Player player);

}
