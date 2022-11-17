package com.jsg.house.user.model.mapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.jsg.house.user.model.dto.User;

public interface UserMapper {
	List<Object> getUserList() throws SQLException;

	int registUser(User user) throws SQLException;

	int deleteUser(int id) throws SQLException;
	
	int modifyUser(HashMap<String,Object> map) throws SQLException;
	
	int idCheck(String account) throws SQLException;

	User loginUser(HashMap<String, String> map) throws SQLException;

	int findUserByEmail(String email) throws SQLException;
}
