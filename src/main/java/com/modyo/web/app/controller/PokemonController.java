package com.modyo.web.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modyo.web.app.entity.EffectEntries;
import com.modyo.web.app.entity.Pokemon;
import com.modyo.web.app.entity.Pokemons;
import com.modyo.web.app.service.JsonService;

@CrossOrigin(origins= {"http://localhost:4200" , "*"})
@RestController
@RequestMapping("/api")
public class PokemonController {
	
	Logger logger = Logger.getLogger("POKEMONS LOGG");
	
	@Value("${pokemon.endpoint}")
	private String url;
	
	@Value("${abilities.endpoint}")
	private String urlAbilities;
	
	@Value("${evolution.endpoint}")
	private String urlEvolution;
	
	@Autowired
	JsonService jsonService;
	
	@GetMapping("/pokemons/{offSet}")
	public List<Pokemon> findAllPokemons(@PathVariable() int offSet) {
		
		logger.info("LIST OF POKEMONS");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		
		HttpEntity<String> entity = new HttpEntity<>(headers);
		String endPoint = url;
		
		if(offSet > 0) {
			endPoint = endPoint.concat("?offset=" + offSet + "&limit=20");
		}
		
		Pokemons pokemons = (Pokemons) jsonService.parseAll(endPoint, entity);
		
		Pokemon pokemon = new Pokemon();
		List<Pokemon> pokemonsList = new ArrayList<Pokemon>();
		
		for(Pokemon p:pokemons.getResults()) {
			pokemon = (Pokemon) jsonService.parse(p.getUrl(), entity);
			pokemonsList.add(pokemon);	
		}
		pokemons.setResults(pokemonsList);
		
		return pokemonsList;
	}
	
	@SuppressWarnings("unused")
	@GetMapping("pokemons/details/{id}")
	public ResponseEntity<?> getPokemonDetail(@PathVariable String id) {
		
		logger.info("POKEMON ID " + id);

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		
		HttpEntity<String> entity = new HttpEntity<>(headers);
		Map<String, Object> response = new HashMap<>();
		Pokemon pokemon = null;
		try {			
			pokemon = (Pokemon) jsonService.parse(url + id, entity);
			EffectEntries effects = (EffectEntries) jsonService.parseEffects(urlAbilities + id);
			
			List<EffectEntries> listEffects = Arrays.asList(effects);
			
			pokemon.setEffectEntries(listEffects);
		} catch(Exception e) {
			response.put("message", "Pokemon doesn't exist");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if(pokemon == null) {
			response.put("message", "Pokemon doesn't exist");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Pokemon>(pokemon, HttpStatus.OK);
	}

}
