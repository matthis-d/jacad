package com.jacad.footapp.service.impl;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jacad.footapp.dao.TeamDao;
import com.jacad.footapp.domain.Team;
import com.jacad.footapp.service.TeamService;

/**
 * The Class TeamServiceImpl.
 */
@Service("teamService")
public class TeamServiceImpl implements TeamService {
	
	/** The logger. */
	static Logger logger = Logger.getLogger(TeamServiceImpl.class);
	
	/** The team dao. */
	@Autowired
	private TeamDao teamDao;

	/* (non-Javadoc)
	 * @see com.jacad.footapp.service.TeamService#getTeamById(java.lang.Integer)
	 */
	@Override
	@Transactional(readOnly=true)
	public Team getTeamById(Integer id) {
		
		logger.info("Gets the team that has the id " + id);
		
		return this.teamDao.getTeamById(id);
	}

	/* (non-Javadoc)
	 * @see com.jacad.footapp.service.TeamService#getAllTeams()
	 */
	@Override
	@Transactional(readOnly=true)
	public Collection<Team> getAllTeams() {
		
		logger.info("Gets all the teams");
		
		return this.teamDao.getAllTeams();
	}

	/* (non-Javadoc)
	 * @see com.jacad.footapp.service.TeamService#addTeam(com.jacad.footapp.domain.Team)
	 */
	@Override
	@Transactional
	public void addTeam(Team team) {
		
		logger.info("Adds the team " + team.toString());
		
		this.teamDao.addTeam(team);
	}

	/* (non-Javadoc)
	 * @see com.jacad.footapp.service.TeamService#removeTeam(java.lang.Integer)
	 */
	@Override
	@Transactional
	public void removeTeam(Integer id) {
		
		logger.info("Removes the team that has the id " + id);
		
		this.teamDao.removeTeam(id);
	}

	/* (non-Javadoc)
	 * @see com.jacad.footapp.service.TeamService#updateTeam(com.jacad.footapp.domain.Team)
	 */
	@Override
	@Transactional
	public void updateTeam(Team team) {
		
		logger.info("Update the team " + team.toString());
		
		this.teamDao.updateTeam(team);
	}

	/* (non-Javadoc)
	 * @see com.jacad.footapp.service.TeamService#getTeamByName(java.lang.String)
	 */
	@Override
	@Transactional(readOnly=true)
	public Team getTeamByName(String name) {
		
		logger.info("Gets the team that has the name " + name);
		
		return this.teamDao.getTeamByName(name);
	}

}
