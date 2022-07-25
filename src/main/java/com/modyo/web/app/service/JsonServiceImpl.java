package com.modyo.web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.modyo.web.app.entity.Pokemons;
import com.modyo.web.app.entity.Pokemon;
import com.modyo.web.app.entity.Chain;
import com.modyo.web.app.entity.EffectEntries;

@Service
public class JsonServiceImpl implements JsonService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Object parse(String url, HttpEntity<String> entity) {
		return restTemplate.getForObject(url, Pokemon.class);
	}

	@Override
	public Object parseAll(String url, HttpEntity<String> entity) {
		return restTemplate.exchange(url, HttpMethod.GET, null, Pokemons.class).getBody();
	}
	
	@Override
	public Object parseEffects(String url) {
		return restTemplate.getForObject(url, EffectEntries.class);
	}

	@Override
	public Object parseEvolution(String url) {
		return restTemplate.getForEntity(url, Object.class);
	}

	@Override
	public Chain parseEvolvesTo(String url, HttpEntity<String> entity) {
		return restTemplate.exchange(url, HttpMethod.GET, entity, Chain.class).getBody();
	}

}
