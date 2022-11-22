package com.jsg.house.apt.model.mapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface AptInfoMapper {
	List<Object> getAptList(String code) throws SQLException;

	List<Object> getsidogugunAptList(HashMap<String, String> map) throws SQLException;

	List<Object> getAptDealList(String code) throws SQLException;
	
	List<Object> getUserInterApts(int userId) throws SQLException;
	int addUserInterApt(HashMap<String, Object> map) throws SQLException;
	int deleteUserInterApt(HashMap<String, Object> map) throws SQLException;
}
