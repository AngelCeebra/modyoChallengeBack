package com.modyo.web.app.service;

import org.springframework.http.HttpEntity;

public interface JsonService {

	Object parse(String url, HttpEntity<String> entity);
	
	Object parseAll(String url, HttpEntity<String> entity);

	Object parseEffects(String url, HttpEntity<String> entity);
	
}
