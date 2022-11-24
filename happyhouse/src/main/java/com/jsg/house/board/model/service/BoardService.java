package com.jsg.house.board.model.service;

import java.util.HashMap;
import java.util.List;

import com.jsg.house.board.model.dto.Board;

public interface BoardService {

	List<Object> listBoard(HashMap<String, Object> map);

	void writeBoard(Board board);

	List<Object> viewBoard(String boardId);

	void modifyBoard(HashMap<String, Object> map);

	void deleteBoard(String boardId);

	List<Object> getSidoName();

	List<Object> getGugunName(String code);

	int getTotalBoard(HashMap<String, Object> map);

	List<Object> listBoardByName(String name);
}
