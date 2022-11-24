package com.jsg.house.interest.model.service;

import java.util.List;

import com.jsg.house.interest.model.dto.Interest;

public interface InterestService {

	List<Object> getInterests(int userid);

	void addInterests(Interest interest);
	
	void deleteInterests(Interest interest);

	List<Object> getRankingIntersts(int sidoCode);

}
