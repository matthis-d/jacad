package com.jacad.footapp.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
@Entity
@Table(name="player")
public class Player implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	/**
	 * Instantiates a new player.
	 */
	public Player() {
		super();
	}

	/**
	 * Instantiates a new player.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param birthDate the birth date
	 * @param position the position
	 * @param weight the weight
	 * @param height the height
	 */
	public Player(String firstName, String lastName, Date birthDate,
			String position, Float weight, Float height) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.position = position;
		this.weight = weight;
		this.height = height;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="player_id", unique=true, nullable=false)
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	@Column(name="firstname", nullable=false, length=255)
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	@Column(name="lastname", nullable=false, length=255)
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the birth date.
	 *
	 * @return the birth date
	 */
	@Temporal(TemporalType.DATE)
	@Column(name="birthdate", nullable=true)
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * Sets the birth date.
	 *
	 * @param birthDate the new birth date
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	@Column(name="position", length=255, nullable=true)
	public String getPosition() {
		return position;
	}

	/**
	 * Sets the position.
	 *
	 * @param position the new position
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	@Column(name="weight", nullable=true)
	public Float getWeight() {
		return weight;
	}

	/**
	 * Sets the weight.
	 *
	 * @param weight the new weight
	 */
	public void setWeight(Float weight) {
		this.weight = weight;
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public Float getHeight() {
		return height;
	}

	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	@Column(name="height", nullable=true)
	public void setHeight(Float height) {
		this.height = height;
	}

	/**
	 * Gets the team.
	 *
	 * @return the team
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@Column(name="team_id", unique=true, nullable=false)
	public Team getTeam() {
		return team;
	}

	/**
	 * Sets the team.
	 *
	 * @param team the new team
	 */
	public void setTeam(Team team) {
		this.team = team;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", birthDate=");
		builder.append(birthDate);
		builder.append(", position=");
		builder.append(position);
		builder.append(", weight=");
		builder.append(weight);
		builder.append(", height=");
		builder.append(height);
		builder.append("]");
		return builder.toString();
	}

}
