package com.jsg.house.board.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.jsg.house.board.model.dto.Board;

public interface BoardMapper {

	List<Object> listBoard() throws SQLException;

	int writeBoard(Board board) throws SQLException;

	List<Object> viewBoard(String boardId) throws SQLException;

	int modifyBoard(Board board) throws SQLException;

	int deleteBoard(String boardId) throws SQLException;

}
