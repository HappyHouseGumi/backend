package com.jsg.house.qna.model.service;

import java.util.HashMap;
import java.util.List;

import com.jsg.house.board.model.dto.Board;
import com.jsg.house.qna.model.dto.Qna;

public interface QnaService {

	List<Object> listQna();

	List<Object> listQnaPaging(HashMap<String, Object> map);
	
	void addQna(Qna qna);
	
	void deleteQna(int id);
	
	void modifyQna(HashMap<String,Object> map);
	
	Object detailQna(int id);
	
	List<Object> searchQna(HashMap<String, Object> map);
	
	int getTotalQna(HashMap<String, Object> map);

}
