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
	public List<Object> getInterests(int userid) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getInterests(userid);
	}

	@Override
	public int addInterests(Interest interest) throws Exception {
		// TODO Auto-generated method stub
		return mapper.addInterests(interest);
	}

	@Override
	public int deleteInterests(Interest interest) throws Exception {
		// TODO Auto-generated method stub
		return mapper.deleteInterests(interest);
	}

}
