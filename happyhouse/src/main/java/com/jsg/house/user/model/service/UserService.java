package com.jsg.house.user.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.jsg.house.user.model.dto.User;

public interface UserService {
	List<Object> getUserList();

	int registUser(User user);

	int deleteUser(int id);
	
	int addAdmin(int id);
	
	int modifyUser(HashMap<String,Object> map);

	int checkNick(String nickName);

	int loginUser(HashMap<String, String> map);
	
	User detailUser(int id);
	
	int findUserByEmail(String email);
	
	int countOauth() throws Exception;

	int findUserByOauth(String accessToken) throws Exception;

	void addUserOauth(HashMap<String, Object> OauthMap) throws Exception;
	
	void registOauthUser(User user) throws Exception;

	int deleteForceUser(int userid);
}
