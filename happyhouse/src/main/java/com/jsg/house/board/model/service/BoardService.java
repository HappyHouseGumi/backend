package com.jsg.house.board.model.service;

import java.util.List;

import com.jsg.house.board.model.dto.Board;

public interface BoardService {

	List<Object> listBoard() throws Exception;

	int writeBoard(Board board) throws Exception;

	List<Object> viewBoard(String boardId) throws Exception;

	int modifyBoard(Board board) throws Exception;

	int deleteBoard(String boardId) throws Exception;

}
