package com.jacad.footapp.dao.impl;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jacad.footapp.dao.TeamDao;
import com.jacad.footapp.domain.Team;

@Repository
public class TeamDaoImpl implements TeamDao {
	
	static Logger logger = Logger.getLogger(TeamDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Team getTeamById(Integer id) {
		
		return (Team) this.sessionFactory.getCurrentSession()
				.createQuery("FROM Team team WHERE team.id = ?")
				.setParameter(0, id)
				.uniqueResult();
	}

	@Override
	public Collection<Team> getAllTeams() {
		
		return (Collection<Team>) this.sessionFactory.getCurrentSession()
				.createQuery("FROM Team team")
				.list();
	}

	@Override
	public void addTeam(Team team) {
		
		this.sessionFactory.getCurrentSession().save(team);

	}

	@Override
	public void removeTeam(Integer id) {
		
		Team team = this.getTeamById(id);
		
		this.sessionFactory.getCurrentSession().delete(team);

	}

	@Override
	public void updateTeam(Team team) {
		
		logger.info("In update team");
		
		Integer id = team.getId();
		Team theTeam = this.getTeamById(id);
		theTeam = team;
		this.sessionFactory.getCurrentSession().merge(theTeam);

	}

	@Override
	public Team getTeamByName(String name) {
		
		return (Team) this.sessionFactory.getCurrentSession()
				.createQuery("FROM Team team WHERE team.name = :name")
				.setParameter("name", name)
				.uniqueResult();
	}

}
