package com.jacad.footapp.dao.impl;

import java.util.Collection;

import org.hibernate.SessionFactory;

import com.jacad.footapp.dao.PlayerDao;
import com.jacad.footapp.domain.Player;

public class PlayerDaoImpl implements PlayerDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Player getPlayerById(Integer id) {
		
		return (Player) this.sessionFactory.getCurrentSession()
				.createQuery("FROM player p WHERE p.id = ?")
				.setParameter(0, id)
				.uniqueResult();
	}

	@Override
	public Collection<Player> getAllPlayers() {
		
		return this.sessionFactory.getCurrentSession()
				.createQuery("FROM player p")
				.list();
	}

	@Override
	public void removePlayer(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPlayer(Player player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePlayer(Player player) {
		// TODO Auto-generated method stub

	}

}
