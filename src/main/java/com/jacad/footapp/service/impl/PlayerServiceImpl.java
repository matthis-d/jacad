package com.jacad.footapp.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacad.footapp.dao.PlayerDao;
import com.jacad.footapp.domain.Player;
import com.jacad.footapp.service.PlayerService;

@Service("playerService")
public class PlayerServiceImpl implements PlayerService {

	/** The player dao. */
	@Autowired
	private PlayerDao playerDao;
	
	@Override
	public Player getPlayerById(Integer id) {
		
		return this.playerDao.getPlayerById(id);
	}

	@Override
	public Collection<Player> getAllPlayers() {
		
		return this.playerDao.getAllPlayers();
	}

	@Override
	public void removePlayer(Integer id) {
		
		this.playerDao.removePlayer(id);
	}

	@Override
	public void addPlayer(Player player) {
		
		this.playerDao.addPlayer(player);
	}

	@Override
	public void updatePlayer(Player player) {
		
		this.playerDao.updatePlayer(player);
	}

}
