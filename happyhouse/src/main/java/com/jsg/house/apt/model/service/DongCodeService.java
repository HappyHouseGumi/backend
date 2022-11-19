package com.jsg.house.apt.model.service;

import java.sql.SQLException;
import java.util.List;

import com.jsg.house.apt.model.dto.DongCode;

public interface DongCodeService {
	List<Object> getSido() throws Exception;
	List<Object> getGugun(String code) throws Exception;
	List<Object> getDong(String code) throws Exception;
	List<Object> clusterSido() throws Exception;
	List<Object> cluster() throws Exception;
	List<Object> clusterGugun() throws Exception;
}
