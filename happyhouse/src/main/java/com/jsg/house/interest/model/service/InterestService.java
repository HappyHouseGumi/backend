package com.jsg.house.interest.model.service;

import java.util.List;

import com.jsg.house.interest.model.dto.Interest;

public interface InterestService {

	List<Object> getInterests(int userid) throws Exception;

	int addInterests(Interest interest) throws Exception;
	int deleteInterests(int id) throws Exception;

}
