package com.jsg.house.interest.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.jsg.house.interest.model.dto.Interest;

public interface InterestMapper {

	List<Object> getInterests(int userid) throws SQLException;

	int addInterests(Interest interest) throws SQLException;

	int deleteInterests(int id) throws SQLException;

}
