package com.modyo.web.app.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class Sprites implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@JsonProperty("front_default")
	private String frontDefault;
	
	public String getFrontDefault() {
		return frontDefault;
	}
	public void setFrontDefault(String frontDefault) {
		this.frontDefault = frontDefault;
	}
	
}
