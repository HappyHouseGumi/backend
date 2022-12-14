package com.jsg.house.apt.model.service;

import java.sql.SQLException;
import java.util.HashMap;
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

	@Override
	public List<Object> getDongNameAptList(String dongName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getsidogugunAptList(HashMap<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getsidogugunAptList(map);
	}

	@Override
	public List<Object> getAptDealList(String code) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getAptDealList(code);
	}

	@Override
	public List<Object> getUserInterApts(int userId) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getUserInterApts(userId);
	}

	@Override
	public int addUserInterApt(HashMap<String, Object> map) throws SQLException {
		// TODO Auto-generated method stub
		return mapper.addUserInterApt(map);
	}

	@Override
	public int deleteUserInterApt(HashMap<String, Object> map) throws SQLException {
		// TODO Auto-generated method stub
		return mapper.deleteUserInterApt(map);
	}
	
}
