package com.modyo.web.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class Effect {

	@JsonProperty("effect")
	private String effect;
	
	@JsonProperty("short_effect")
	private String shortEffect;

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getshortEffect() {
		return shortEffect;
	}

	public void setshortEffect(String shortEffect) {
		this.shortEffect = shortEffect;
	}
	
}
