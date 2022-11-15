package com.jsg.house.interest.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.house.interest.model.dto.Interest;
import com.jsg.house.interest.model.mapper.InterestMapper;

@Service
public class InterestServiceImpl implements InterestService {
	
	@Autowired
	private InterestMapper mapper;
	
	@Override
	public List<Object> getIntersts(int userid) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getInterests(userid);
	}

	@Override
	public int addIntersts(Interest interest) throws Exception {
		// TODO Auto-generated method stub
		return mapper.addIntersts(interest);
	}

	@Override
	public int deleteIntersts(int id) throws Exception {
		// TODO Auto-generated method stub
		return mapper.deleteIntersts(id);
	}

}
