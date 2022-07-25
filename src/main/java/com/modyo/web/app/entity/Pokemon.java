package com.modyo.web.app.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class Pokemon implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private int weight;
	private String url;
	
	@JsonProperty("sprites")
	private Sprites sprites;
	
	
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	@JsonProperty("abilities")
	private List<Abilities> ability;
	
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	@JsonProperty("types")
	private List<Types> types;
	
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	@JsonProperty("effect_entries")
	private List<EffectEntries> effectEntries;
	
//	@JsonProperty("chain")
//	private EvolvesTo chain;
	
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Abilities> getAbility() {
		return ability;
	}
	public void setAbility(List<Abilities> ability) {
		this.ability = ability;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Sprites getSprites() {
		return sprites;
	}
	public void setSprites(Sprites sprites) {
		this.sprites = sprites;
	}
	public List<Types> getTypes() {
		return types;
	}
	public void setTypes(List<Types> types) {
		this.types = types;
	}
	public List<EffectEntries> getEffectEntries() {
		return effectEntries;
	}
	public void setEffectEntries(List<EffectEntries> effectEntries) {
		this.effectEntries = effectEntries;
	}
//	public EvolvesTo getChain() {
//		return chain;
//	}
//	public void setChain(EvolvesTo chain) {
//		this.chain = chain;
//	}
	
}
