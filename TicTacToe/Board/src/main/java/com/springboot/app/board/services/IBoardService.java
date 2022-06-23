package com.springboot.app.board.services;

import com.springboot.app.board.dto.BoardDto;
import com.springboot.app.board.entities.BoardEntity;

public interface IBoardService {
	
	public BoardEntity create(BoardEntity board);

	public BoardDto getBoardById(Integer id);

}