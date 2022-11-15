package com.jsg.house.interest.model.service;

import java.util.List;

import com.jsg.house.interest.model.dto.Interest;

public interface InterestService {

	List<Object> getIntersts(int userid) throws Exception;

	int addIntersts(Interest interest) throws Exception;
	int deleteIntersts(int id) throws Exception;

}
