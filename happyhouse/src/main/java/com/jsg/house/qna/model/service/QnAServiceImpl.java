package com.jsg.house.qna.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.house.board.model.dto.Board;
import com.jsg.house.qna.model.dto.QnA;
import com.jsg.house.qna.model.mapper.QnAMapper;

@Service
public class QnAServiceImpl implements QnAService {
	
	@Autowired
	private QnAMapper mapper;
	

	@Override
	public List<Object> listQnA() throws Exception {
		return mapper.listQnA();
	}


	@Override
	public int addQnA(QnA qna) throws Exception {
		// TODO Auto-generated method stub
		return mapper.addQnA(qna);
	}


	@Override
	public int deleteQnA(int id) throws Exception {
		// TODO Auto-generated method stub
		return mapper.deleteQnA(id);
	}


	@Override
	public int modifyQnA(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return mapper.modifyQnA(map);
	}


	@Override
	public Object detailQnA(int id) throws Exception {
		// TODO Auto-generated method stub
		return mapper.detailQnA(id);
	}


}
