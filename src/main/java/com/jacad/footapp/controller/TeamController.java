package com.jacad.footapp.controller;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.jacad.footapp.domain.Player;
import com.jacad.footapp.domain.Team;
import com.jacad.footapp.service.PlayerService;
import com.jacad.footapp.service.TeamService;

@ManagedBean
@RequestScoped
public class TeamController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static Logger logger = Logger.getLogger(TeamController.class);

	private TeamService teamService;
	
	private PlayerService playerService;
	
	private Team team;
	
	private Integer id;
	
	private Collection<Team> teams;
	
	private String name;
	
	private String colors;
	
	private String stadiumName;
	
	private Integer creationYear;
	
	public TeamController() {
		
		logger.info("In TeamController constructor");
		
	
		ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		this.teamService = ctx.getBean("teamService", TeamService.class);
		this.playerService = ctx.getBean("playerService", PlayerService.class);	
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Collection<Team> getTeams() {
		logger.info("In getTeams");
		this.teams = this.teamService.getAllTeams();
		return teams;
	}

	public void setTeams(Collection<Team> teams) {
		this.teams = teams;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColors() {
		return colors;
	}

	public void setColors(String colors) {
		this.colors = colors;
	}

	public String getStadiumName() {
		return stadiumName;
	}

	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

	public Integer getCreationYear() {
		return creationYear;
	}

	public void setCreationYear(Integer creationYear) {
		this.creationYear = creationYear;
	}

	public void findTeam() {
		
		logger.info("In findTeam");
		
		if(this.isSetId()) {
			this.team = this.teamService.getTeamById(this.id);
			
			logger.info("The team is: " + this.team.toString());
			
			this.name = this.team.getName();
			this.colors = this.team.getColors();
			this.stadiumName = this.team.getStadiumName();
			this.creationYear = this.team.getCreationYear();
			
			this.team.setPlayers(this.playerService.getAllPlayersFromTeamId(this.id));
		}
		else {
			Set<Player> players = new HashSet<>();
			this.team = new Team("Undefined", "", "", 0, players);
		}
	}
	
	public boolean isSetId(){
		//Todo : bugged :p
		/*
		if(this.id == 0 || (this.id > this.teams.size()) ){
			return Boolean.FALSE;
		}
		else {
			return Boolean.TRUE;
		}*/
		return Boolean.TRUE;
	}
	
	public String createTeam() {
		if(this.name.isEmpty() || this.colors.isEmpty() || this.creationYear == 0 || this.stadiumName.isEmpty()) {
			return "addEquipe";
		}
		else {
			Team team = new Team();
			team.setName(this.name);
			team.setColors(this.colors);
			team.setStadiumName(this.stadiumName);
			team.setCreationYear(this.creationYear);
			team.setPlayers(new HashSet<Player>());
			
			this.teamService.addTeam(team);
			
			return "equipes";
		}
	}
	
	public String editTeam() {
		
		logger.info("In edit team");
		
		if(this.name.isEmpty() || this.colors.isEmpty() || this.creationYear == 0 || this.stadiumName.isEmpty()) {
			
			logger.info("Something is missing during the edition");
			
			return "editEquipe?id="+this.getId();
		}
		else {
			
			this.team = this.teamService.getTeamById(this.id);
			
			logger.info("Set the new name");
			logger.info(this.name);
			this.team.setName(this.name);
			
			logger.info("Set the new colors");
			logger.info(this.colors);
			this.team.setColors(this.colors);
			
			logger.info("Set the new stadium name");
			logger.info(this.stadiumName);
			this.team.setStadiumName(this.stadiumName);
			
			logger.info("Set the new creation year");
			logger.info(this.creationYear);
			this.team.setCreationYear(this.creationYear);
			
			logger.info("Update the team");
			this.teamService.updateTeam(team);
			
			return "equipes";
		}
	}
	
}

