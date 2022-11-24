package com.jsg.house.apt.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.jsg.house.apt.model.dto.DongCode;

public interface DongCodeMapper {
	List<Object> getSido() throws SQLException;
	List<Object> getGugun(String code) throws SQLException;
	List<Object> getDong(String code) throws SQLException;
	List<Object> clusterSido() throws SQLException;
	List<Object> clusterGugun() throws SQLException;
	List<Object> cluster() throws SQLException;
	Object getLatLng(String dongCode) throws SQLException;
}
