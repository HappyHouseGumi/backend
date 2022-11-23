package com.jsg.house.like.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.house.exception.NoDataException;
import com.jsg.house.exception.NotChangeDataException;
import com.jsg.house.like.model.dto.Like;
import com.jsg.house.like.model.mapper.LikeMapper;
import com.jsg.house.util.SizeConstant;

@Service
public class LikeServiceImpl implements LikeService {

	private LikeMapper mapper;

	@Autowired
	public LikeServiceImpl(LikeMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<Object> listLike(HashMap<String, Object> map) {

		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("key", map.get("key") == null ? "" : (String) map.get("key"));
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int pgNo = (Integer)map.get("pgno") == null ? 1 : (Integer)map.get("pgno");
		int start = pgNo * SizeConstant.LIST_SIZE - SizeConstant.LIST_SIZE;
		param.put("start", start);
		param.put("listsize", SizeConstant.LIST_SIZE);

		List<Object> likeList = null;

		try {
			likeList = mapper.listLike(param);
			if (likeList == null || likeList.isEmpty()) {
				throw new NoDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NoDataException();
		}

		return likeList;
	}

	@Override
	public void registLike(Like like) {
		int checkSum = 0;
		try {
			checkSum = mapper.registLike(like);
			if (checkSum != 1) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NotChangeDataException();
		}
	}

	@Override
	public void deleteLike(HashMap<String, String> map) {
		int checkSum = 0;
		try {
			checkSum = mapper.deleteLike(map);
			if (checkSum != 1) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
//			e.printStackTrace();
			throw new NotChangeDataException();
		}
	}

	@Override
	public int checkLike(HashMap<String, Object> map) {
		int checkSum = 0;
		try {
			checkSum = mapper.checkLike(map);
			if (checkSum == -1) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NotChangeDataException();
		}
		return checkSum;
	}


	@Override
	public int getTotalLike(HashMap<String, Object> map) {
		int checkSum = 0;
		try {
			checkSum = mapper.getTotalLike(map);
			if (checkSum == -1) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NotChangeDataException();
		}
		return checkSum;
	}

	@Override
	public int getCountLike(String boardId) {
		int checkSum = 0;
		try {
			checkSum = mapper.getCountLike(boardId);
			if (checkSum == -1) {
				throw new NoDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NoDataException();
		}
		return checkSum;
	}
}
