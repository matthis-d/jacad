package com.jacad.footapp.controller;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
 * The Class PlayerController.
 *
 */
@ManagedBean
@RequestScoped
public class PlayerController implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The logger. */
	static Logger logger = Logger.getLogger(PlayerController.class);
	
	/** The team service. */
	private TeamService teamService;
	
	/** The player service. */
	private PlayerService playerService;
	
	/** The players. */
	private Collection<Player> players;
	
	/** The player. */
	private Player player; 
	
	/** The id. */
	private Integer id;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The birth date. */
	private Date birthDate;
	
	/** The position. */
	private String position;
	
	/** The weight. */
	private Float weight;
	
	/** The height. */
	private Float height;
	
	/** The team. */
	private Team team;
	
	/** The team id. */
	private Integer teamId;
	
	/** The teams. */
	private Collection<Team> teams;

	/**
	 * Instantiates a new player controller.
	 */
	public PlayerController() {
		super();
		
		logger.info("Instanciates player controller");
		
		ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		this.teamService = ctx.getBean("teamService", TeamService.class);
		this.playerService = ctx.getBean("playerService", PlayerService.class);	
	}

	/**
	 * Gets the players.
	 *
	 * @return the players
	 */
	public Collection<Player> getPlayers() {
		
		logger.info("Request for all the players");
		
		this.players = this.playerService.getAllPlayers();
		
		return players;
	}

	/**
	 * Sets the players.
	 *
	 * @param players the new players
	 */
	public void setPlayers(Collection<Player> players) {
		
		logger.info("Sets the collection of players");
		
		this.players = players;
	}

	/**
	 * Gets the player.
	 *
	 * @return the player
	 */
	public Player getPlayer() {
		
		logger.info("Gets the player of this instance");
		
		return player;
	}

	/**
	 * Sets the player.
	 *
	 * @param player the new player
	 */
	public void setPlayer(Player player) {
		
		logger.info("Sets the player of this instance");
		
		this.player = player;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		
		logger.info("Gets the id of the player of this instance");
		
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		
		logger.info("Sets the id of the player of this instance");
		
		this.id = id;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		
		logger.info("Gets the first name of the player of this instance");
		
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		
		logger.info("Sets the last name of the player of this instance");
		
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		
		logger.info("Gets the last name of the player of this instance");
		
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		
		logger.info("Sets the last name of the player of this instance");
		
		this.lastName = lastName;
	}

	/**
	 * Gets the birth date.
	 *
	 * @return the birth date
	 */
	public Date getBirthDate() {
		
		logger.info("Gets the birth date of the player of this instance");
		
		return birthDate;
	}

	/**
	 * Sets the birth date.
	 *
	 * @param birthDate the new birth date
	 */
	public void setBirthDate(Date birthDate) {
		
		logger.info("Sets the birth date of the player of this instance");
		
		this.birthDate = birthDate;
	}

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public String getPosition() {
		
		logger.info("Gets the position of the player of this instance");
		
		return position;
	}

	/**
	 * Sets the position.
	 *
	 * @param position the new position
	 */
	public void setPosition(String position) {
		
		logger.info("Sets the position of the player of this instance");
		
		this.position = position;
	}

	/**
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public Float getWeight() {
		
		logger.info("Gets the weight of the player of this instance");
		
		return weight;
	}

	/**
	 * Sets the weight.
	 *
	 * @param weight the new weight
	 */
	public void setWeight(Float weight) {
		
		logger.info("Sets the weight of the player of this instance");
		
		this.weight = weight;
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public Float getHeight() {
		
		logger.info("Gets the height of the player of this instance");
		
		return height;
	}

	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	public void setHeight(Float height) {
		
		logger.info("Sets the height of the player of this instance");
		
		this.height = height;
	}

	/**
	 * Gets the team.
	 *
	 * @return the team
	 */
	public Team getTeam() {
		
		logger.info("Gets the team of the player of this instance");
		
		return team;
	}

	/**
	 * Sets the team.
	 *
	 * @param team the new team
	 */
	public void setTeam(Team team) {
		
		logger.info("Sets the team of the player of this instance");
		
		this.team = team;
	}
	
	/**
	 * Gets the teams.
	 *
	 * @return the teams
	 */
	public Collection<Team> getTeams() {
		
		logger.info("Gets the teams of this instance");
		
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
	 * Gets the team id.
	 *
	 * @return the team id
	 */
	public Integer getTeamId() {
		
		logger.info("Gets the id of the team of this instance");
		
		return teamId;
	}

	/**
	 * Sets the team id.
	 *
	 * @param teamId the new team id
	 */
	public void setTeamId(Integer teamId) {
		
		logger.info("Sets the id of the team of this instance");
		
		this.teamId = teamId;
	}

	/**
	 * Find player.
	 */
	public void findPlayer() {
		
		logger.info("Finds the player corresponding to the id set in this instance");
		
		this.player = this.playerService.getPlayerById(this.id);
		
		logger.info("Sets all the information corresponding to the player of this instance");
		
		this.firstName = this.player.getFirstName();
		this.lastName = this.player.getLastName();
		this.birthDate = this.player.getBirthDate();
		this.height = this.player.getHeight();
		this.weight = this.player.getWeight();
		this.position = this.player.getPosition();
		this.team = this.player.getTeam();
	}
	
	/**
	 * Creates the player.
	 *
	 * @return the string
	 */
	public String createPlayer() {
		if(this.firstName.isEmpty() || this.lastName.isEmpty() || this.position.isEmpty() ) {
			
			logger.warn("Some fields are missing for the creation of a player");
			
			return "addJoueur";
		}
		else {
			
			logger.info("Gets the team selected in the form");
			
			this.team = this.teamService.getTeamById(this.teamId);
			
			logger.info("Creates a new player according to the information put in the form");
			
			Player player = new Player();
			player.setFirstName(this.firstName);
			player.setLastName(this.lastName);
			player.setWeight(this.weight);
			player.setHeight(this.height);
			player.setPosition(this.position);
			player.setTeam(this.team);
			player.setBirthDate(this.birthDate);
			
			logger.info("Adds a player in the database");
			this.playerService.addPlayer(player);
			
			logger.info("Redirection to the page \"players.xhtml\"");
			return "joueurs";
		}
	}
	
	/**
	 * Edits the player.
	 *
	 * @return the string
	 */
	public String editPlayer() {
		if(this.firstName.isEmpty() || this.lastName.isEmpty() || this.position.isEmpty() ) {
			logger.warn("Some fields are missing for the creation of a player");
			return "editJoueur?id=" + this.getId();
		}
		else {
			
			logger.info("Gets the team selected in the form");
			this.team = this.teamService.getTeamById(this.teamId);
			
			logger.info("Creates a new player according to the information put in the form");
			Player player = this.playerService.getPlayerById(this.id);
			
			player.setFirstName(this.firstName);
			player.setLastName(this.lastName);
			player.setWeight(this.weight);
			player.setHeight(this.height);
			player.setPosition(this.position);
			player.setTeam(this.team);
			player.setBirthDate(this.birthDate);
			
			logger.info("Updates the player in the database");
			this.playerService.updatePlayer(player);
			
			logger.info("Redirection to the page \"players.xhtml\"");
			return "joueurs";
		}
	}
	
	/**
	 * Delete player.
	 *
	 * @return the string
	 */
	public String deletePlayer() {
		
		logger.info("Deletes the player selected in the database");
		this.playerService.removePlayer(this.id);
		
		logger.info("Redirection to the page \"players.xhtml\"");
		return "joueurs";
	}
	
	/**
	 * Find teams.
	 */
	public void findTeams() {
		
		logger.info("Find all the teams in the database");
		this.teams = this.teamService.getAllTeams();
	}

	/**
	 * Gets the map of teams.
	 *
	 * @return the map of teams
	 */
	public Map<String, String> getMapOfTeams() {

		logger.info("Creates a map of teams and ids for the select list in the add/edit page");
		
		Map<String, String> result = new HashMap<String, String>();
		
		this.teams = this.teamService.getAllTeams();
		
		for (Team team : this.teams) {
			
			result.put(team.getName(), team.getId().toString());
		}
		
		return result;		
	}
}
