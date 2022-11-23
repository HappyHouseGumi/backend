package com.jsg.house.like.model.service;

import java.util.HashMap;
import java.util.List;

import com.jsg.house.like.model.dto.Like;

public interface LikeService {

	List<Object> listLike(HashMap<String, Object> map);

	void registLike(Like like);

	void deleteLike(HashMap<String, String> map);

	int checkLike(HashMap<String, Object> map);

	int getTotalLike(HashMap<String, Object> map);

	int getCountLike(String boardId);

	List<Object> getLikeUser(String boardId);

}
