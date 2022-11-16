package com.jsg.house.qna.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.jsg.house.board.model.dto.Board;
import com.jsg.house.qna.model.dto.QnA;

public interface QnAService {

	List<Object> listQnA() throws Exception;
	int addQnA(QnA qna) throws Exception;
	int deleteQnA(int id) throws Exception;
	int modifyQnA(HashMap<String,Object> map) throws Exception;
	Object detailQnA(int id) throws Exception;
}
