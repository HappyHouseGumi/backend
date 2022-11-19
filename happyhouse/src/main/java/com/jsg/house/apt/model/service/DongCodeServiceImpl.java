package com.jsg.house.apt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.house.apt.model.dto.DongCode;
import com.jsg.house.apt.model.mapper.DongCodeMapper;

@Service
public class DongCodeServiceImpl implements DongCodeService {
	
	@Autowired
	private DongCodeMapper mapper;
	
	@Override
	public List<Object> getSido() throws Exception {
		// TODO Auto-generated method stub
		return mapper.getSido();
	}

	@Override
	public List<Object> getGugun(String code) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getGugun(code);
	}

	@Override
	public List<Object> getDong(String code) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getDong(code);
	}

	@Override
	public List<Object> clusterSido() throws Exception {
		// TODO Auto-generated method stub
		return mapper.clusterSido();
	}
	@Override
	public List<Object> clusterGugun() throws Exception {
		// TODO Auto-generated method stub
		return mapper.clusterGugun();
	}
	@Override
	public List<Object> cluster() throws Exception {
		// TODO Auto-generated method stub
		return mapper.cluster();
	}
}
