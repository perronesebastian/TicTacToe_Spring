package com.springboot.app.player.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.springboot.app.player.dtos.CoordinateDto;

@FeignClient(name = "tictactoe-coordinate", url = "localhost:8004")
public interface CoordinateClientRest {
	// @TODO: la url deberia ser /coordinates/etc ya que son varias coordenadas las que se consultan
	@GetMapping("/coordinate/player/{playerId}")
	// @TODO: con respecto al name de este metodo se suele poner como nombre: getCoordinatesBy(parametro) osea el nombre del parametro ya indica que es por un playerId en este caso entonces no hace falta aclarar "PlayerId" en el nombre del metodo
	public List<CoordinateDto> getCoordinatesByPlayerId(@PathVariable("playerId") Integer playerId);
	
	// @TODO: porque todos estos espacios en blancos? y elimina la palabra public de la cabecera del metodo de la interfaz
}
