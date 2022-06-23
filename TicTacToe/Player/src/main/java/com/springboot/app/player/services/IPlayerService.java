package com.springboot.app.player.services;

import com.springboot.app.player.dtos.PlayerDto;
import com.springboot.app.player.entities.PlayerEntity;

public interface IPlayerService {
	// @TODO: en las cabeceras de los metodos de una interfaz la palabra public no hace falta ya que por defecto se usa.
	// @TODO: este metodo deberia recibir como parametro un DTO, no un entity y retornar al controlador un DTO no un entity, te explico: el service es el encardo de mappear las cosas de dto a entity y de entity a dto
	public PlayerEntity create(PlayerEntity player);
	
	public PlayerDto getPlayerById(Integer id);

}
