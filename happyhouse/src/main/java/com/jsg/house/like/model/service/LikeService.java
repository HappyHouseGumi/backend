package com.jsg.house.like.model.service;

import java.util.List;

import com.jsg.house.like.model.dto.Like;

public interface LikeService {

	List<Object> listLike() throws Exception;

	int registLike(Like like) throws Exception;

	int deleteLike(String likeId) throws Exception;

}
