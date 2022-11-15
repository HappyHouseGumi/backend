package com.jsg.house.board.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.house.board.model.dto.Board;
import com.jsg.house.board.model.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	BoardMapper mapper;
	
	@Autowired
	public BoardServiceImpl(BoardMapper mapper) {
		super();
		this.mapper = mapper;
	}

	@Override
	public List<Object> listBoard() throws Exception {
		return mapper.listBoard();
	}

	@Override
	public int writeBoard(Board board) throws Exception {
		return mapper.writeBoard(board);
	}

	@Override
	public List<Object> viewBoard(String boardId) throws Exception {
		return mapper.viewBoard(boardId);
	}

	@Override
	public int modifyBoard(Board board) throws SQLException {
		return mapper.modifyBoard(board);
	}

	@Override
	public int deleteBoard(String boardId) throws Exception {
		return mapper.deleteBoard(boardId);
	}

	

}
