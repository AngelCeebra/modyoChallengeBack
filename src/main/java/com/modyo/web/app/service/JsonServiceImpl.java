package com.modyo.web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.modyo.web.app.entity.EffectEntries;
import com.modyo.web.app.entity.Pokemon;
import com.modyo.web.app.entity.Pokemons;

@Service
public class JsonServiceImpl implements JsonService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Object parse(String url, HttpEntity<String> entity) {
		return restTemplate.exchange(url, HttpMethod.GET, entity, Pokemon.class).getBody();
	}

	@Override
	public Object parseAll(String url, HttpEntity<String> entity) {
		return restTemplate.exchange(url, HttpMethod.GET, entity, Pokemons.class).getBody();
	}
	
	@Override
	public Object parseEffects(String url, HttpEntity<String> entityl) {
		return restTemplate.exchange(url, HttpMethod.GET, entityl, EffectEntries.class).getBody();
	}

}
