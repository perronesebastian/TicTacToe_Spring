package com.springboot.app.player.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.app.player.clients.CoordinateClientRest;
import com.springboot.app.player.dtos.PlayerDto;
import com.springboot.app.player.entities.PlayerEntity;
import com.springboot.app.player.repository.PlayerRepository;

@Service
public class PlayerService implements IPlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private CoordinateClientRest coordinateClientRest;

	@Override
	public PlayerEntity create(PlayerEntity player) {
		// @TODO: aca tenes que parsear el resultado del .save (entity) a DTO y retornar al controller un DTO
		return playerRepository.save(player);
	}
	
	@Override
	public PlayerDto getPlayerById(Integer id) {
		PlayerEntity playerEntity = playerRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Player with id %s does not exist", id)));;
		return this.toDto(playerEntity);	
	}

	// @TODO: este metodo se usa unicamente en esta clase, entonces no deberia ser public deberia ser? ...
	public PlayerDto toDto(PlayerEntity playerEntity) {
		PlayerDto playerDto = new PlayerDto();
		playerDto.setId(playerEntity.getId());
		// @TODO: que pasa si la llamada a getCoordinatesByPlayerId falla o da error? ya sea porque el otro microservicio esta caido o algo, aca estas asumiendo que el valor viene siempre y lo estas seteando automaticamente
		// @TODO: pero deberias tener un control de si la llamada por rest al otro microservicio fue bien o fallo
		playerDto.setCoordinates(coordinateClientRest.getCoordinatesByPlayerId(playerEntity.getId()));
		playerDto.setUsername(playerEntity.getUsername());
		playerDto.setPassword(playerEntity.getPassword());
		return playerDto;
	}
}