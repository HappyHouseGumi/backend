package com.jsg.house.board.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.house.board.model.dto.Board;
import com.jsg.house.board.model.mapper.BoardMapper;
import com.jsg.house.util.SizeConstant;

@Service
public class BoardServiceImpl implements BoardService {
	
	BoardMapper mapper;
	
	@Autowired
	public BoardServiceImpl(BoardMapper mapper) {
		super();
		this.mapper = mapper;
	}

	@Override
	public List<Object> listBoard(HashMap<String, Object> map) throws Exception {
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("key", map.get("key") == null ? "" : (String)map.get("key"));
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int pgNo = Integer.parseInt((String)map.get("pgno") == null ? "1" : (String)map.get("pgno"));
		int start = pgNo * SizeConstant.LIST_SIZE - SizeConstant.LIST_SIZE;
		param.put("start", start);
		param.put("listsize", SizeConstant.LIST_SIZE);
		
		return mapper.listBoard(param);
	}

	@Override
	public int writeBoard(Board board) throws Exception {
		return mapper.writeBoard(board);
	}

	@Override
	public List<Object> viewBoard(String boardId) throws Exception {
		mapper.hitupdate(boardId);
		return mapper.viewBoard(boardId);
	}

	@Override
	public int modifyBoard(HashMap<String, Object> map) throws SQLException {
		return mapper.modifyBoard(map);
	}

	@Override
	public int deleteBoard(String boardId) throws Exception {
		return mapper.deleteBoard(boardId);
	}

	@Override
	public List<Object> getSidoName() throws Exception {
		return mapper.getSidoName();
	}

	@Override
	public List<Object> getGugunName(String code) throws Exception {
		return mapper.getGugunName(code);
	}

	

}
