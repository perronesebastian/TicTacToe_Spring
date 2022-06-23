package com.springboot.app.coordinate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.coordinate.dto.CoordinateDto;
import com.springboot.app.coordinate.entities.CoordinateEntity;
import com.springboot.app.coordinate.services.ICoordinateService;

@RestController
@RequestMapping("/coordinate")
public class CoordinateController {
	
	@Autowired
	private ICoordinateService coordinateService;
	
	@PostMapping("/put")
	public ResponseEntity<CoordinateEntity> create(@RequestBody CoordinateEntity target) {
		return new ResponseEntity<CoordinateEntity>(coordinateService.create(target), HttpStatus.OK);
	}
	
	@GetMapping("player/{playerId}")
	public ResponseEntity<List<CoordinateDto>> getCoordinatesByPlayerId(@PathVariable("playerId") Integer playerId) {
		return new ResponseEntity<List<CoordinateDto>> (coordinateService.getCoordinatesByPlayerId(playerId), HttpStatus.OK);
	}

}
