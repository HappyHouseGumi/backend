package com.jsg.house.like.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.house.like.model.dto.Like;
import com.jsg.house.like.model.mapper.LikeMapper;

@Service
public class LikeServiceImpl implements LikeService {

	private LikeMapper mapper;

	@Autowired
	public LikeServiceImpl(LikeMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<Object> listLike() throws Exception {
		return mapper.listLike();
	}

	@Override
	public int registLike(Like like) throws Exception {
		return mapper.registLike(like);
	}

	@Override
	public int deleteLike(String likeId) throws Exception {
		return mapper.deleteLike(likeId);
	}

}
