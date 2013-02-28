package com.jacad.footapp.controller;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.jacad.footapp.domain.Team;
import com.jacad.footapp.service.TeamService;

@FacesConverter("TeamConverter")
public class TeamConverter implements Converter {
	
	private TeamService teamService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(context);
		this.teamService = ctx.getBean("teamService", TeamService.class);
		
		Team team = this.teamService.getTeamByName(value);
		
		return team;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		return value.toString();
	}

}
