package com.jsg.house.board.model.mapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.jsg.house.board.model.dto.Board;

public interface BoardMapper {

	List<Object> listBoard(HashMap<String, Object> map) throws SQLException;

	int writeBoard(Board board) throws SQLException;

	List<Object> viewBoard(String boardId) throws SQLException;

	int modifyBoard(HashMap<String, Object> map) throws SQLException;

	int deleteBoard(String boardId) throws SQLException;

	int hitupdate(String boardId) throws SQLException;

	List<Object> getSidoName() throws SQLException;

	List<Object> getGugunName(String code) throws SQLException;

	int getTotalBoard(HashMap<String, Object> map) throws SQLException;

}