package com.jacad.footapp.dao;

import java.util.Collection;

import com.jacad.footapp.domain.Team;

/**
 * The Interface TeamDao.
 */
public interface TeamDao {
	
	/**
	 * Gets the team by id.
	 *
	 * @param id the id
	 * @return the team by id
	 */
	public Team getTeamById(Integer id);
	
	/**
	 * Gets the all teams.
	 *
	 * @return the all teams
	 */
	public Collection<Team> getAllTeams();
	
	/**
	 * Adds the team.
	 *
	 * @param team the team
	 */
	public void addTeam(Team team);
	
	/**
	 * Removes the team.
	 *
	 * @param id the id
	 */
	public void removeTeam(Integer id);
	
	/**
	 * Update team.
	 *
	 * @param team the team
	 */
	public void updateTeam(Team team);

	
	/**
	 * Gets the team by name.
	 *
	 * @param name the name
	 * @return the team by name
	 */
	public Team getTeamByName(String name);

}
