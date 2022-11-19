package com.jsg.house.like.model.mapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.jsg.house.like.model.dto.Like;

public interface LikeMapper {

	List<Object> listLike(HashMap<String, Object> map) throws SQLException;

	int registLike(Like like) throws SQLException;

	int deleteLike(String likeId) throws SQLException;

}
