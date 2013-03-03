package com.jacad.footapp.dao.impl;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jacad.footapp.dao.PlayerDao;
import com.jacad.footapp.domain.Player;
import com.jacad.footapp.domain.Team;

/**
 * The Class PlayerDaoImpl.
 */
@Repository
public class PlayerDaoImpl implements PlayerDao {
	
	/** The logger. */
	static Logger logger = Logger.getLogger(PlayerDaoImpl.class);
	
	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Sets the session factory.
	 *
	 * @param sessionFactory the new session factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		
		logger.info("Sets the session factory");
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see com.jacad.footapp.dao.PlayerDao#getPlayerById(java.lang.Integer)
	 */
	@Override
	public Player getPlayerById(Integer id) {
		
		logger.info("Gets the player which has the id " + id);
		
		return (Player) this.sessionFactory.getCurrentSession()
				.createQuery("FROM Player player WHERE player.id = ?")
				.setParameter(0, id)
				.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.jacad.footapp.dao.PlayerDao#getAllPlayers()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Player> getAllPlayers() {
		
		logger.info("Gets all the players from the database");
		
		return this.sessionFactory.getCurrentSession()
				.createQuery("FROM Player p")
				.list();
	}
	
	/* (non-Javadoc)
	 * @see com.jacad.footapp.dao.PlayerDao#getAllPlayersFromTeamId(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Player> getAllPlayersFromTeamId(Integer id) {
		
		logger.info("Gets the team which has the id " + id);
		
		Team team = (Team)this.sessionFactory.getCurrentSession()
				.createQuery("FROM Team t WHERE t.id = :id")
				.setParameter("id", id)
				.uniqueResult();
		
		logger.info("Gets all the players that are in that team");
		
		return this.sessionFactory.getCurrentSession()
				.createQuery("FROM Player p WHERE p.team = ?")
				.setParameter(0, team)
				.list();
	}

	/* (non-Javadoc)
	 * @see com.jacad.footapp.dao.PlayerDao#removePlayer(java.lang.Integer)
	 */
	@Override
	public void removePlayer(Integer id) {
		
		logger.info("Removes the player that has this is from the database");
		Player player = this.getPlayerById(id);
		this.sessionFactory.getCurrentSession().delete(player);

	}

	/* (non-Javadoc)
	 * @see com.jacad.footapp.dao.PlayerDao#addPlayer(com.jacad.footapp.domain.Player)
	 */
	@Override
	public void addPlayer(Player player) {
		
		logger.info("Adds the player " + player.toString() + " in the databse");
		this.sessionFactory.getCurrentSession().save(player);

	}

	/* (non-Javadoc)
	 * @see com.jacad.footapp.dao.PlayerDao#updatePlayer(com.jacad.footapp.domain.Player)
	 */
	@Override
	public void updatePlayer(Player player) {
		
		logger.info("Updates the player with the id " + player.getId() + " in the databse");
		Integer id = player.getId();
		Player thePlayer = this.getPlayerById(id);
		thePlayer = player;
		this.sessionFactory.getCurrentSession().merge(thePlayer);

	}

}
