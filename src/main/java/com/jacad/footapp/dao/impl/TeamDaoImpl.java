package com.jacad.footapp.dao.impl;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jacad.footapp.dao.TeamDao;
import com.jacad.footapp.domain.Team;

/**
 * The Class TeamDaoImpl.
 */
@Repository
public class TeamDaoImpl implements TeamDao {
	
	/** The logger. */
	static Logger logger = Logger.getLogger(TeamDaoImpl.class);
	
	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Sets the session factory.
	 *
	 * @param sessionFactory the new session factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		
		logger.info("Sets the session factory for the teams");
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see com.jacad.footapp.dao.TeamDao#getTeamById(java.lang.Integer)
	 */
	@Override
	public Team getTeamById(Integer id) {
		
		logger.info("Gets the team from the database that has this id " + id);
		
		return (Team) this.sessionFactory.getCurrentSession()
				.createQuery("FROM Team team WHERE team.id = ?")
				.setParameter(0, id)
				.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.jacad.footapp.dao.TeamDao#getAllTeams()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Team> getAllTeams() {
		
		logger.info("Gets all the teams from the database");
		
		return (Collection<Team>) this.sessionFactory.getCurrentSession()
				.createQuery("FROM Team team")
				.list();
	}

	/* (non-Javadoc)
	 * @see com.jacad.footapp.dao.TeamDao#addTeam(com.jacad.footapp.domain.Team)
	 */
	@Override
	public void addTeam(Team team) {
		
		logger.info("Add the team " + team.toString() + " in the databse");		
		this.sessionFactory.getCurrentSession().save(team);

	}

	/* (non-Javadoc)
	 * @see com.jacad.footapp.dao.TeamDao#removeTeam(java.lang.Integer)
	 */
	@Override
	public void removeTeam(Integer id) {
		
		logger.info("Removes the team from the database that has this id " + id);
		
		Team team = this.getTeamById(id);
		
		this.sessionFactory.getCurrentSession().delete(team);

	}

	/* (non-Javadoc)
	 * @see com.jacad.footapp.dao.TeamDao#updateTeam(com.jacad.footapp.domain.Team)
	 */
	@Override
	public void updateTeam(Team team) {
		
		logger.info("Updates the team " + team.toString() + "in the databse");
		
		Integer id = team.getId();
		Team theTeam = this.getTeamById(id);
		theTeam = team;
		this.sessionFactory.getCurrentSession().merge(theTeam);

	}

	/* (non-Javadoc)
	 * @see com.jacad.footapp.dao.TeamDao#getTeamByName(java.lang.String)
	 */
	@Override
	public Team getTeamByName(String name) {
		
		logger.info("Gets the team from the database that has this name " + name);
		
		return (Team) this.sessionFactory.getCurrentSession()
				.createQuery("FROM Team team WHERE team.name = :name")
				.setParameter("name", name)
				.uniqueResult();
	}

}
