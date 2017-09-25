package com.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.domain.Position;

@RestController
@RequestMapping("/trade")
public class SimpleController {

	private static Map<String, Integer> tradePortFolio = new HashMap<>();
	private static List<String> availableToTrade = new ArrayList<String>();

	static {
		availableToTrade.add("IBM");
	}

	@RequestMapping(name = "buy", 
			value = "/buy", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.ALL_VALUE)
	public ResponseEntity<String> buy(@RequestBody Position position,HttpServletRequest req,HttpServletResponse res) {
		String result = "ok";
		tradePortFolio.put(position.getStock().getSymbol(), tradePortFolio.get(position.getStock()) == null ? 0
				: tradePortFolio.get(position.getStock()) + position.getQuantity());
		return new ResponseEntity<String>(
				"Bought " + position.getQuantity() + " shares of " + position.getStock().getSymbol(), HttpStatus.OK);
	}

	@RequestMapping(name = "sell", value = "/sell", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.ALL_VALUE)
	public ResponseEntity<String> sell(@RequestBody Position position) {
		String result = "ok";
		tradePortFolio.put(position.getStock().getSymbol(),
				tradePortFolio.get(position.getStock()) - position.getQuantity());
		return new ResponseEntity<String>(
				"Sold " + position.getQuantity() + " shares of " + position.getStock().getSymbol(), HttpStatus.OK);
	}

}
