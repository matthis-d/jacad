package com.jacad.footapp.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jacad.footapp.dao.PlayerDao;
import com.jacad.footapp.domain.Player;
import com.jacad.footapp.service.PlayerService;

@Service("playerService")
@Transactional
public class PlayerServiceImpl implements PlayerService {

	/** The player dao. */
	@Autowired
	private PlayerDao playerDao;
	
	@Override
	@Transactional(readOnly=true)
	public Player getPlayerById(Integer id) {
		
		return this.playerDao.getPlayerById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Player> getAllPlayers() {
		
		return this.playerDao.getAllPlayers();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Collection<Player> getAllPlayersFromTeamId(Integer id) {
		
		return this.playerDao.getAllPlayersFromTeamId(id);
	}

	@Override
	@Transactional
	public void removePlayer(Integer id) {
		
		
		this.playerDao.removePlayer(id);
	}

	@Override
	@Transactional
	public void addPlayer(Player player) {
		
		this.playerDao.addPlayer(player);
	}

	@Override
	@Transactional
	public void updatePlayer(Player player) {
		
		this.playerDao.updatePlayer(player);
	}

}
