//package com.springboot.app.game.utils;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.springboot.app.game.clients.BoardClientRest;
//import com.springboot.app.game.clients.PlayerClientRest;
//import com.springboot.app.game.dto.GameDto;
//import com.springboot.app.game.entities.GameEntity;
//
//public class MapperGame {
//	
//	@Autowired
//	private PlayerClientRest playerClientRest;
//	
//	@Autowired
//	private BoardClientRest boardClientRest;
//	
//	public GameDto toDto(GameEntity gameEntity) {
//		GameDto gameDto = new GameDto();
//		gameDto.setBoard(boardClientRest.getBoardById(gameEntity.getBoard_id()));
//		gameDto.setPlayer_1(playerClientRest.getPlayerById(gameEntity.getPlayer_id_1()));
//		gameDto.setPlayer_2(playerClientRest.getPlayerById(gameEntity.getPlayer_id_2()));
//		return gameDto;
//	}
	
//	public GameEntity toEntity(GameDto gameDto, GameEntity gameEntity) {
//		gameEntity.setBoard_id(gameDto.getBoard_id());
//		gameEntity.setPlayer_id_1(gameDto.getPlayer_id_1());
//		gameEntity.setPlayer_id_2(gameDto.getPlayer_id_2());
//		gameEntity.setState(gameDto.getState());
//		gameEntity.setTurn(gameDto.getTurn());
//		return gameEntity;
//	}
//}
