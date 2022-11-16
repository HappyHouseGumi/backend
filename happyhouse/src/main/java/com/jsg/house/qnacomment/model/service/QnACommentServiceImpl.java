package com.jsg.house.qnacomment.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.house.qnacomment.model.dto.QnAComment;
import com.jsg.house.qnacomment.model.mapper.QnACommentMapper;

@Service
public class QnACommentServiceImpl implements QnACommentService {
	
	private QnACommentMapper mapper;
	
	@Autowired
	public QnACommentServiceImpl(QnACommentMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<Object> listQnAComment(int qnaId) throws Exception {
		return mapper.listQnAComment(qnaId);
	}

	@Override
	public int writeQnAComment(QnAComment comment) throws Exception {
		return mapper.writeQnAComment(comment);
	}

	@Override
	public int modifyQnAComment(HashMap<String,Object> map) throws Exception {
		return mapper.modifyQnAComment(map);
	}

	@Override
	public int deleteQnAComment(int id) throws Exception {
		return mapper.deleteQnAComment(id);
	}

}
