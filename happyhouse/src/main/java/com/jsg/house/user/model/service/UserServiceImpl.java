package com.jsg.house.user.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.house.user.model.dto.User;
import com.jsg.house.user.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper mapper;
	
	@Override
	public List<Object> getUserList() throws Exception {
		return mapper.getUserList();
	}

	@Override
	public int registUser(User user) throws Exception  {
		// TODO Auto-generated method stub
		return mapper.registUser(user);
	}

	@Override
	public int deleteUser(int id) throws Exception {
		// TODO Auto-generated method stub
		return mapper.deleteUser(id);
	}

	@Override
	public int modifyUser(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return mapper.modifyUser(map);
	}

	@Override
	public int checkNick(String nickName) throws Exception {
		// TODO Auto-generated method stub
		return mapper.checkNick(nickName);
	}

	@Override
	public User loginUser(HashMap<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return mapper.loginUser(map);
	}

	@Override
	public int findUserByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return mapper.findUserByEmail(email);
	}

	@Override
	public int findUserByOauth(String accessToken) throws Exception {
		return mapper.findUserByOauth(accessToken);
	}

	@Override
	public void addUserOauth(HashMap<String, Object> OauthMap) throws Exception {
		mapper.addUserOauth(OauthMap);
		
	}

	@Override
	public int countOauth() throws Exception {
		// TODO Auto-generated method stub
		return mapper.countOauth();
	}

	@Override
	public void registOauthUser(User user) throws Exception {
		mapper.registOauthUser(user);
		
	}
	
}
