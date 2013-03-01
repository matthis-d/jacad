package com.jacad.footapp.controller;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.jacad.footapp.domain.Player;
import com.jacad.footapp.domain.Team;
import com.jacad.footapp.service.PlayerService;
import com.jacad.footapp.service.TeamService;

@ManagedBean
@RequestScoped
public class PlayerController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TeamService teamService;
	
	private PlayerService playerService;
	
	private Collection<Player> players;
	
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
	
	private Integer teamId;
	
	private Collection<Team> teams;

	public PlayerController() {
		super();
		
		ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		this.teamService = ctx.getBean("teamService", TeamService.class);
		this.playerService = ctx.getBean("playerService", PlayerService.class);	
	}

	public Collection<Player> getPlayers() {
		
		this.players = this.playerService.getAllPlayers();
		
		return players;
	}

	public void setPlayers(Collection<Player> players) {
		this.players = players;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	public Collection<Team> getTeams() {
		return teams;
	}

	public void setTeams(Collection<Team> teams) {
		this.teams = teams;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public void findPlayer() {
		
		this.player = this.playerService.getPlayerById(this.id);
		
		this.firstName = this.player.getFirstName();
		this.lastName = this.player.getLastName();
		this.birthDate = this.player.getBirthDate();
		this.height = this.player.getHeight();
		this.weight = this.player.getWeight();
		this.position = this.player.getPosition();
		this.team = this.player.getTeam();
	}
	
	public String createPlayer() {
		if(this.firstName.isEmpty() || this.lastName.isEmpty() || this.position.isEmpty() ) {
			return "addJoueur";
		}
		else {			
			this.team = this.teamService.getTeamById(this.teamId);
			
			Player player = new Player();
			player.setFirstName(this.firstName);
			player.setLastName(this.lastName);
			player.setWeight(this.weight);
			player.setHeight(this.height);
			player.setPosition(this.position);
			player.setTeam(this.team);
			player.setBirthDate(this.birthDate);
			
			this.playerService.addPlayer(player);
			
			return "joueurs";
		}
	}
	
	public String editPlayer() {
		if(this.firstName.isEmpty() || this.lastName.isEmpty() || this.position.isEmpty() ) {
			return "editJoueur?id=" + this.getId();
		}
		else {
			Player player = this.playerService.getPlayerById(this.id);
			
			player.setFirstName(this.firstName);
			player.setLastName(this.lastName);
			player.setWeight(this.weight);
			player.setHeight(this.height);
			player.setPosition(this.position);
			player.setTeam(this.team);
			player.setBirthDate(this.birthDate);
			
			this.playerService.updatePlayer(player);
			
			return "joueurs";
		}
	}
	
	public String deletePlayer() {
		this.playerService.removePlayer(this.id);
		return "joueurs";
	}
	
	public void findTeams() {
		
		this.teams = this.teamService.getAllTeams();
	}

	public Map<String, String> getMapOfTeams() {

		Map<String, String> result = new HashMap<String, String>();
		
		this.teams = this.teamService.getAllTeams();
		
		for (Team team : this.teams) {
			
			result.put(team.getName(), team.getId().toString());
		}
		
		return result;		
	}
}
