package com.modyo.web.app.service;

import org.springframework.http.HttpEntity;

import com.modyo.web.app.entity.Chain;

public interface JsonService {

	Object parse(String url, HttpEntity<String> entity);
	
	Object parseAll(String url, HttpEntity<String> entity);

	Object parseEffects(String url);
	
	Object parseEvolution(String url);
	
	Chain parseEvolvesTo(String url, HttpEntity<String> entity);
	
}
