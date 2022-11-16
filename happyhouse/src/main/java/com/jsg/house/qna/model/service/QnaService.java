package com.jsg.house.qna.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.jsg.house.board.model.dto.Board;
import com.jsg.house.qna.model.dto.Qna;

public interface QnaService {

	List<Object> listQna() throws Exception;
	int addQna(Qna qna) throws Exception;
	int deleteQna(int id) throws Exception;
	int modifyQna(HashMap<String,Object> map) throws Exception;
	Object detailQna(int id) throws Exception;
	List<Object> searchQna(HashMap<String, Object> map) throws Exception;
}
