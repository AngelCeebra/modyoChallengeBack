package com.modyo.web.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

//@JsonIgnoreProperties
public class EvolvesTo {
	
	@JsonProperty("evolves_to")
	private List<EvolvesTo> evolvesTo;
	
	@SerializedName("species")
	private List<Species> species;
	
	private List<EvolutionDetails> evolutionDetails;

	public List<Species> getSpecies() {
		return species;
	}

	public void setSpecies(List<Species> species) {
		this.species = species;
	}

	public List<EvolutionDetails> getEvolutionDetails() {
		return evolutionDetails;
	}

	public void setEvolutionDetails(List<EvolutionDetails> evolutionDetails) {
		this.evolutionDetails = evolutionDetails;
	}

	public List<EvolvesTo> getEvolvesTo() {
		return evolvesTo;
	}

	public void setEvolvesTo(List<EvolvesTo> evolvesTo) {
		this.evolvesTo = evolvesTo;
	}

	
	
}
