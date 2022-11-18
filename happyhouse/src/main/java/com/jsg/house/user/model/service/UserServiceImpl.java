package com.jsg.house.user.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.house.exception.NoDataException;
import com.jsg.house.exception.NotChangeDataException;
import com.jsg.house.user.model.dto.User;
import com.jsg.house.user.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper mapper;
	
	@Override
	public List<Object> getUserList() {
		List<Object> userList = new ArrayList<Object>();
		try {
			userList = mapper.getUserList();
			if (userList == null || userList.isEmpty()) {
				throw new NoDataException();
			}
		} catch (SQLException e) {
			throw new NoDataException();
		}
		
		return userList;
	}

	@Override
	public int registUser(User user)  {
		int checkSum = 0;
		try {
			checkSum = mapper.registUser(user);
			if(checkSum != 1) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
			throw new NotChangeDataException();
		}
		return 1;
	}

	@Override
	public int deleteUser(int id) {
		int checkSum = 0;
		try {
			checkSum = mapper.deleteUser(id);
			if(checkSum != 1) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
			throw new NotChangeDataException();
		}
		return 1;
	}

	@Override
	public int modifyUser(HashMap<String, Object> map){
		int checkSum = 0;
		try {
			checkSum = mapper.modifyUser(map);
			if(checkSum != 1) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
			throw new NotChangeDataException();
		}
		return 1;
	}

	@Override
	public int checkNick(String nickName) {
		// TODO Auto-generated method stub
		int checkSum = 0;
		try {
			checkSum = mapper.checkNick(nickName);
			if(checkSum == 1) {
				return 1; 
			}
		} catch (SQLException e) {
			return 0;
		}
		return 0;
	}

	@Override
	public int loginUser(HashMap<String, String> map) {
		User user = null;
		try {
			user = mapper.loginUser(map);
			if(user == null) {
				throw new NoDataException();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new NoDataException();
		}
		return user.getId();
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
