package com.springboot.app.board.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.springboot.app.board.dto.BoardDto;
import com.springboot.app.board.entities.BoardEntity;
import com.springboot.app.board.repository.BoardRepository;

@Service
public class BoardService implements IBoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Override
	public BoardEntity create(BoardEntity boardEntity) {
		return boardRepository.save(boardEntity);
	}
	
	@Override
	public BoardDto getBoardById(Integer id) {
		BoardEntity boardEntity = boardRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Board with id %s does not exist", id)));
		BoardDto boardDto = this.toDto(boardEntity);
		return boardDto;
	}

	private BoardDto toDto(BoardEntity boardEntity) {
		BoardDto boardDto = new BoardDto();
		boardDto.setId(boardEntity.getId());
		boardDto.setDimension(boardEntity.getDimension());
		return boardDto;
	}

}
