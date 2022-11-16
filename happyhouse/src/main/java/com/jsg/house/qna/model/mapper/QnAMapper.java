package com.jsg.house.qna.model.mapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.jsg.house.qna.model.dto.QnA;

public interface QnAMapper {

	List<Object> listQnA() throws SQLException;
	int addQnA(QnA qna) throws SQLException;
	int deleteQnA(int id) throws SQLException;
	int modifyQnA(HashMap<String,Object> map) throws SQLException;
}
