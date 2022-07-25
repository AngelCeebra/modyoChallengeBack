package com.modyo.web.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class Abilities {

	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	@JsonProperty("ability")
	private List<Ability> ability;

	public List<Ability> getAbility() {
		return ability;
	}

	public void setAbility(List<Ability> ability) {
		this.ability = ability;
	}
	
	
}
