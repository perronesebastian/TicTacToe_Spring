package com.springboot.app.game.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.game.dto.GameDto;
import com.springboot.app.game.entities.GameEntity;
import com.springboot.app.game.service.IGameService;


@RestController
@RequestMapping("/game")
public class GameController {
	
	@Autowired
	private IGameService gameService;
	
	@PostMapping("/create")
	public ResponseEntity<GameEntity> create(@RequestBody GameEntity game) {
		return new ResponseEntity<GameEntity>(gameService.create(game), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GameDto> getGame(@PathVariable("id") Integer id) {
		return new ResponseEntity<GameDto>(gameService.getGame(id), HttpStatus.OK);
	}

}
