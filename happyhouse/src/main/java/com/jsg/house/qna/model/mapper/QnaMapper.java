package com.jsg.house.qna.model.mapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.jsg.house.qna.model.dto.Qna;

public interface QnaMapper {

	List<Object> listQna() throws SQLException;
	int addQna(Qna qna) throws SQLException;
	int deleteQna(int id) throws SQLException;
	int modifyQna(HashMap<String,Object> map) throws SQLException;
	Object detailQna(int id) throws SQLException;
	List<Object> searchQna(HashMap<String, Object> map) throws SQLException;
}
