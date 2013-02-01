package com.jacad.footapp.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacad.footapp.dao.TeamDao;
import com.jacad.footapp.domain.Team;
import com.jacad.footapp.service.TeamService;

@Service("teamService")
public class TeamServiceImpl implements TeamService {
	
	/** The team dao. */
	@Autowired
	private TeamDao teamDao;

	@Override
	public Team getTeamById(Integer id) {
		
		return this.teamDao.getTeamById(id);
	}

	@Override
	public Collection<Team> getAllTeams() {
		
		return this.teamDao.getAllTeams();
	}

	@Override
	public void addTeam(Team team) {
		
		this.teamDao.addTeam(team);
	}

	@Override
	public void removeTeam(Integer id) {
		
		this.teamDao.removeTeam(id);
	}

	@Override
	public void updateTeam(Team team) {
		
		this.teamDao.updateTeam(team);
	}

}
