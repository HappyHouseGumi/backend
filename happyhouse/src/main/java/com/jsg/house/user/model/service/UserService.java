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

	int idCheck(String account) throws Exception;

	User loginUser(HashMap<String, String> map) throws Exception;
}
