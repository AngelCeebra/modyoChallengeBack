package com.modyo.web.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties
public class Chain {

	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	@JsonProperty("evolves_to")
	private List<EvolvesTo> evolvesTo;
	
	private Species species;
	
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	public List<EvolvesTo> getEvolvesTo() {
		return evolvesTo;
	}

	public void setEvolvesTo(List<EvolvesTo> evolvesTo) {
		this.evolvesTo = evolvesTo;
	}
	
}
