package com.jsg.house.qna.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.house.board.model.dto.Board;
import com.jsg.house.qna.model.dto.Qna;
import com.jsg.house.qna.model.mapper.QnaMapper;

@Service
public class QnaServiceImpl implements QnaService {
	
	@Autowired
	private QnaMapper mapper;
	

	@Override
	public List<Object> listQna() throws Exception {
		return mapper.listQna();
	}


	@Override
	public int addQna(Qna qna) throws Exception {
		// TODO Auto-generated method stub
		return mapper.addQna(qna);
	}


	@Override
	public int deleteQna(int id) throws Exception {
		// TODO Auto-generated method stub
		return mapper.deleteQna(id);
	}


	@Override
	public int modifyQna(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return mapper.modifyQna(map);
	}


	@Override
	public Object detailQna(int id) throws Exception {
		// TODO Auto-generated method stub
		return mapper.detailQna(id);
	}


	@Override
	public List<Object> searchQna(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return mapper.searchQna(map);
	}


}
