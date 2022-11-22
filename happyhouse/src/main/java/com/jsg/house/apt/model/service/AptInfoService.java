package com.jsg.house.apt.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface AptInfoService {
	List<Object> getAptList(String code) throws Exception;
	List<Object> getDongNameAptList(String dongName) throws Exception;
	List<Object> getsidogugunAptList(HashMap<String, String> map)throws Exception;
	List<Object> getAptDealList(String code) throws Exception;
	List<Object> getUserInterApts(int userId) throws Exception;
	int addUserInterApt(HashMap<String, Object> map) throws SQLException;
	int deleteUserInterApt(HashMap<String, Object> map) throws SQLException;
}
