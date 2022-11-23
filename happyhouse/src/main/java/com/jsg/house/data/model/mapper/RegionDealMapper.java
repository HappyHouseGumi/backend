package com.jsg.house.data.model.mapper;

import java.sql.SQLException;
import java.util.List;

public interface RegionDealMapper {

	List<Object> getAvgDeal(String sidoName) throws SQLException;

}
