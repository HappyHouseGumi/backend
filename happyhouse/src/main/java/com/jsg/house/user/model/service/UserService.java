package com.jsg.house.user.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.jsg.house.user.model.dto.User;

public interface UserService {
	List<Object> getUserList() throws Exception;

	int registUser(User user) throws Exception;

	int deleteUser(int id) throws Exception;
	
	int modifyUser(HashMap<String,Object> map) throws Exception;

	int checkNick(String nickName) throws Exception;

	User loginUser(HashMap<String, String> map) throws Exception;

	int findUserByEmail(String email) throws Exception;
	
	int countOauth() throws Exception;

	int findUserByOauth(String accessToken) throws Exception;

	void addUserOauth(HashMap<String, Object> OauthMap) throws Exception;
	
	void registOauthUser(User user) throws Exception;
}
