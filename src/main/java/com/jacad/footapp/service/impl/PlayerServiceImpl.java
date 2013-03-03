package com.jacad.footapp.service.impl;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jacad.footapp.dao.PlayerDao;
import com.jacad.footapp.domain.Player;
import com.jacad.footapp.service.PlayerService;

/**
 * The Class PlayerServiceImpl.
 */
@Service("playerService")
@Transactional
public class PlayerServiceImpl implements PlayerService {
	
	/** The logger. */
	static Logger logger = Logger.getLogger(PlayerServiceImpl.class);

	/** The player dao. */
	@Autowired
	private PlayerDao playerDao;
	
	/* (non-Javadoc)
	 * @see com.jacad.footapp.service.PlayerService#getPlayerById(java.lang.Integer)
	 */
	@Override
	@Transactional(readOnly=true)
	public Player getPlayerById(Integer id) {
		
		logger.info("Gets the player that has the id " + id);
		
		return this.playerDao.getPlayerById(id);
	}

	/* (non-Javadoc)
	 * @see com.jacad.footapp.service.PlayerService#getAllPlayers()
	 */
	@Override
	@Transactional(readOnly=true)
	public Collection<Player> getAllPlayers() {
		
		logger.info("Gets all the players");
		
		return this.playerDao.getAllPlayers();
	}
	
	/* (non-Javadoc)
	 * @see com.jacad.footapp.service.PlayerService#getAllPlayersFromTeamId(java.lang.Integer)
	 */
	@Override
	@Transactional(readOnly=true)
	public Collection<Player> getAllPlayersFromTeamId(Integer id) {
		
		logger.info("Gets the player that are in the team with the id of " + id);
		
		return this.playerDao.getAllPlayersFromTeamId(id);
	}

	/* (non-Javadoc)
	 * @see com.jacad.footapp.service.PlayerService#removePlayer(java.lang.Integer)
	 */
	@Override
	@Transactional
	public void removePlayer(Integer id) {
		
		logger.info("Removes the player that has the id " + id);
		this.playerDao.removePlayer(id);
	}

	/* (non-Javadoc)
	 * @see com.jacad.footapp.service.PlayerService#addPlayer(com.jacad.footapp.domain.Player)
	 */
	@Override
	@Transactional
	public void addPlayer(Player player) {
		
		logger.info("Adds the player " + player.toString());
		this.playerDao.addPlayer(player);
	}

	/* (non-Javadoc)
	 * @see com.jacad.footapp.service.PlayerService#updatePlayer(com.jacad.footapp.domain.Player)
	 */
	@Override
	@Transactional
	public void updatePlayer(Player player) {
		
		logger.info("Updates the player " + player.toString());
		this.playerDao.updatePlayer(player);
	}

}
