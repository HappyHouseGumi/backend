package com.jsg.house.like.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.jsg.house.like.model.dto.Like;

public interface LikeMapper {

	List<Object> listLike() throws SQLException;

	int registLike(Like like) throws SQLException;

	int deleteLike(String likeId) throws SQLException;

}
