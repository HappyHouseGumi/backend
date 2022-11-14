package com.jsg.house.user.model.service;

import java.sql.SQLException;
import java.util.List;

import com.jsg.house.user.model.dto.User;

public interface UserService {
	List<User> list() throws Exception;
}
