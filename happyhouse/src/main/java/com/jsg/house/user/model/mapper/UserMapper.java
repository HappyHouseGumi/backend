package com.jsg.house.user.model.mapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.jsg.house.user.model.dto.User;

public interface UserMapper {
	List<Object> getUserList() throws SQLException;

	int registUser(User user) throws SQLException;

	int deleteUser(int id) throws SQLException;
	
	int addAdmin(int id) throws SQLException;
	
	int modifyUser(HashMap<String,Object> map) throws SQLException;
	
	int checkNick(String nickName) throws SQLException;

	User loginUser(HashMap<String, String> map) throws SQLException;
	
	User detailUser(int id) throws SQLException;
	
	int findUserByEmail(String email) throws SQLException;
	
	int countOauth() throws SQLException;

	int findUserByOauth(String accessToken) throws SQLException;

	void addUserOauth(HashMap<String, Object> oauthMap) throws SQLException;

	void registOauthUser(User user) throws SQLException;

	int deleteForceUser(int id) throws SQLException;
}
