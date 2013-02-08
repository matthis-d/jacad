package com.jacad.footapp.dao.impl;

import java.util.Collection;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jacad.footapp.dao.PlayerDao;
import com.jacad.footapp.domain.Player;

@Repository
public class PlayerDaoImpl implements PlayerDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Player getPlayerById(Integer id) {
		
		return (Player) this.sessionFactory.getCurrentSession()
				.createQuery("FROM Player player WHERE player.id = ?")
				.setParameter(0, id)
				.uniqueResult();
	}

	@Override
	public Collection<Player> getAllPlayers() {
		
		return this.sessionFactory.getCurrentSession()
				.createQuery("FROM Player p")
				.list();
	}

	@Override
	public void removePlayer(Integer id) {
		
		Player player = this.getPlayerById(id);
		this.sessionFactory.getCurrentSession().delete(player);

	}

	@Override
	public void addPlayer(Player player) {
		this.sessionFactory.getCurrentSession().save(player);

	}

	@Override
	public void updatePlayer(Player player) {
		
		Integer id = player.getId();
		Player thePlayer = this.getPlayerById(id);
		thePlayer = player;
		//TODO: est ce que ça suffit ? 

	}

}
