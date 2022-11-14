package com.jsg.house.user.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.jsg.house.user.model.dto.User;

public interface UserMapper {
	List<User> list() throws SQLException;
}
