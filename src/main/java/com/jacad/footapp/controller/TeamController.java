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

/**
 * The Class TeamController.
 */
@ManagedBean
@RequestScoped
public class TeamController implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The logger. */
	static Logger logger = Logger.getLogger(TeamController.class);

	/** The team service. */
	private TeamService teamService;
	
	/** The player service. */
	private PlayerService playerService;
	
	/** The team. */
	private Team team;
	
	/** The id. */
	private Integer id;
	
	/** The teams. */
	private Collection<Team> teams;
	
	/** The name. */
	private String name;
	
	/** The colors. */
	private String colors;
	
	/** The stadium name. */
	private String stadiumName;
	
	/** The creation year. */
	private Integer creationYear;
	
	/**
	 * Instantiates a new team controller.
	 */
	public TeamController() {
		
		logger.info("In TeamController constructor");
	
		ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		this.teamService = ctx.getBean("teamService", TeamService.class);
		this.playerService = ctx.getBean("playerService", PlayerService.class);	
	}

	/**
	 * Gets the team.
	 *
	 * @return the team
	 */
	public Team getTeam() {
		
		logger.info("Gets the team of this instance");
		return team;
	}

	/**
	 * Sets the team.
	 *
	 * @param team the new team
	 */
	public void setTeam(Team team) {
		
		logger.info("Sets the team of this instance");
		this.team = team;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		
		logger.info("Gets the team's id of this instance");
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		
		logger.info("Sets the team's id of this instance");
		this.id = id;
	}

	/**
	 * Gets the teams.
	 *
	 * @return the teams
	 */
	public Collection<Team> getTeams() {
		logger.info("Gets all the teams from the database");
		this.teams = this.teamService.getAllTeams();
		return teams;
	}

	/**
	 * Sets the teams.
	 *
	 * @param teams the new teams
	 */
	public void setTeams(Collection<Team> teams) {
		
		logger.info("Sets the teams of this instance");
		this.teams = teams;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		
		logger.info("Gets the team's name of this instance");
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		
		logger.info("Sets the team's name of this instance");
		this.name = name;
	}

	/**
	 * Gets the colors.
	 *
	 * @return the colors
	 */
	public String getColors() {
		
		logger.info("Gets the team's colors of this instance");
		return colors;
	}

	/**
	 * Sets the colors.
	 *
	 * @param colors the new colors
	 */
	public void setColors(String colors) {
		
		logger.info("Sets the team's colors of this instance");
		this.colors = colors;
	}

	/**
	 * Gets the stadium name.
	 *
	 * @return the stadium name
	 */
	public String getStadiumName() {
		
		logger.info("Gets the team's stadium name of this instance");
		return stadiumName;
	}

	/**
	 * Sets the stadium name.
	 *
	 * @param stadiumName the new stadium name
	 */
	public void setStadiumName(String stadiumName) {
		
		logger.info("Sets the team's satdium name of this instance");
		this.stadiumName = stadiumName;
	}

	/**
	 * Gets the creation year.
	 *
	 * @return the creation year
	 */
	public Integer getCreationYear() {
		
		logger.info("Gets the team's creation year of this instance");
		return creationYear;
	}

	/**
	 * Sets the creation year.
	 *
	 * @param creationYear the new creation year
	 */
	public void setCreationYear(Integer creationYear) {
		
		logger.info("Sets the team's creation year of this instance");
		this.creationYear = creationYear;
	}

	/**
	 * Find team.
	 */
	public void findTeam() {
		
		logger.info("In findTeam");
		logger.info("Gets the team according to the id in parameter");
		
		logger.info("Gets the team from the database");
		this.team = this.teamService.getTeamById(this.id);
		
		logger.info("The team is: " + this.team.toString());
		
		logger.info("Sets all the information coressponding to this team");
		this.name = this.team.getName();
		this.colors = this.team.getColors();
		this.stadiumName = this.team.getStadiumName();
		this.creationYear = this.team.getCreationYear();
		
		logger.info("Gets the players of this team");
		this.team.setPlayers(this.playerService.getAllPlayersFromTeamId(this.id));
	}
	
	/**
	 * Creates the team.
	 *
	 * @return the string
	 */
	public String createTeam() {
		if(this.name.isEmpty() || this.colors.isEmpty() || this.creationYear == 0 || this.stadiumName.isEmpty()) {
			
			logger.warn("Something is missing in order to create the team");
			return "addEquipe";
		}
		else {
			
			logger.info("Creates a new team according to the inputs");
			Team team = new Team();
			team.setName(this.name);
			team.setColors(this.colors);
			team.setStadiumName(this.stadiumName);
			team.setCreationYear(this.creationYear);
			team.setPlayers(new HashSet<Player>());
			
			logger.info("Adds the team in database");
			this.teamService.addTeam(team);
			
			logger.info("Redirects to the homepage");
			return "equipes";
		}
	}
	
	/**
	 * Edits the team.
	 *
	 * @return the string
	 */
	public String editTeam() {
		
		logger.info("In edit team");
		
		if(this.name.isEmpty() || this.colors.isEmpty() || this.creationYear == 0 || this.stadiumName.isEmpty()) {
			
			logger.warn("Something is missing during the edition");
			
			return "editEquipe?id="+this.getId();
		}
		else {
			
			logger.info("Gets the team correpsonding to the id in parameter");
			
			this.team = this.teamService.getTeamById(this.id);
			
			logger.info("Updates the team according to the inputs");
			
			this.team.setName(this.name);
			
			this.team.setColors(this.colors);
			
			this.team.setStadiumName(this.stadiumName);
			
			this.team.setCreationYear(this.creationYear);
			
			this.teamService.updateTeam(team);
			
			return "equipes";
		}
	}
	
	/**
	 * Delete team.
	 *
	 * @return the string
	 */
	public String deleteTeam() {
		
		logger.info("Removes the team from teh database");		
		this.teamService.removeTeam(this.id);
		return "equipes";
	}
	
}

