package com.jsg.house.board.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.house.board.model.dto.Board;
import com.jsg.house.board.model.mapper.BoardMapper;
import com.jsg.house.exception.NoDataException;
import com.jsg.house.exception.NotChangeDataException;
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
	public List<Object> listBoard(HashMap<String, Object> map) {

		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("key", map.get("key") == null ? "" : (String) map.get("key"));
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int pgNo = (Integer)map.get("pgno") == null ? 1 : (Integer)map.get("pgno");
		int start = pgNo * SizeConstant.LIST_SIZE - SizeConstant.LIST_SIZE;
		param.put("start", start);
		param.put("listsize", SizeConstant.LIST_SIZE);

		List<Object> boardList = null;

		try {
			boardList = mapper.listBoard(param);
			if (boardList == null || boardList.isEmpty()) {
				throw new NoDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NoDataException();
		}

		return boardList;
	}

	@Override
	public void writeBoard(Board board) {
		int checkSum = 0;

		try {
			checkSum = mapper.writeBoard(board);
			if (checkSum == 0) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NotChangeDataException();
		}
	}

	@Override
	public List<Object> viewBoard(String boardId) {

		int checkSum = 0;
		List<Object> vboard = null;

		try {
			checkSum = mapper.hitupdate(boardId);
			if (checkSum == 0) {
				throw new NotChangeDataException();
			}
			vboard = mapper.viewBoard(boardId);
			if (vboard == null || vboard.isEmpty()) {
				throw new NoDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NoDataException();
		}
		return vboard;
	}

	@Override
	public void modifyBoard(HashMap<String, Object> map) {
		int checkSum = 0;

		try {
			checkSum = mapper.modifyBoard(map);
			if (checkSum == 0) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NotChangeDataException();
		}
	}

	@Override
	public void deleteBoard(String boardId) {
		int checkSum = 0;

		try {
			checkSum = mapper.deleteBoard(boardId);
			if (checkSum == 0) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NotChangeDataException();
		}
	}

	@Override
	public List<Object> getSidoName() {
		List<Object> dongcode = null;

		try {
			dongcode = mapper.getSidoName();
			if (dongcode == null || dongcode.isEmpty()) {
				throw new NoDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NoDataException();
		}

		return dongcode;
	}

	@Override
	public List<Object> getGugunName(String code) {
		List<Object> dongcode = null;

		try {
			dongcode = mapper.getGugunName(code);
			if (dongcode == null || dongcode.isEmpty()) {
				throw new NoDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NoDataException();
		}

		return dongcode;
	}
	
	@Override
	public int getTotalBoard(HashMap<String, Object> map) {
		int checkSum = 0;
		try {
			checkSum = mapper.getTotalBoard(map);
			if (checkSum == -1) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NotChangeDataException();
		}
		return checkSum;
	}

}
