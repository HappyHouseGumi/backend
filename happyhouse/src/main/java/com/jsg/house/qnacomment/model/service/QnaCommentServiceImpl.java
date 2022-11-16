package com.jsg.house.qnacomment.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.house.qnacomment.model.dto.QnaComment;
import com.jsg.house.qnacomment.model.mapper.QnaCommentMapper;

@Service
public class QnaCommentServiceImpl implements QnaCommentService {
	
	private QnaCommentMapper mapper;
	
	@Autowired
	public QnaCommentServiceImpl(QnaCommentMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<Object> listQnaComment(int qnaId) throws Exception {
		return mapper.listQnaComment(qnaId);
	}

	@Override
	public int writeQnaComment(QnaComment comment) throws Exception {
		return mapper.writeQnaComment(comment);
	}

	@Override
	public int modifyQnaComment(HashMap<String,Object> map) throws Exception {
		return mapper.modifyQnaComment(map);
	}

	@Override
	public int deleteQnaComment(int id) throws Exception {
		return mapper.deleteQnaComment(id);
	}

}
