package com.springboot.app.player.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.springboot.app.player.dtos.CoordinateDto;

@FeignClient(name = "tictactoe-coordinate", url = "localhost:8004")
public interface CoordinateClientRest {
	
	@GetMapping("/coordinate/player/{playerId}")
	public List<CoordinateDto> getCoordinatesByPlayerId(@PathVariable("playerId") Integer playerId);
	
	
}
