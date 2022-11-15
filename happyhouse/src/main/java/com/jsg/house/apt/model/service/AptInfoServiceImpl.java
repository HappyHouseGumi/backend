package com.jsg.house.apt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.house.apt.model.mapper.AptInfoMapper;

@Service
public class AptInfoServiceImpl implements AptInfoService {

	@Autowired
	private AptInfoMapper mapper;
	
	@Override
	public List<Object> getAptList(String code) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getAptList(code);
	}
	
}
