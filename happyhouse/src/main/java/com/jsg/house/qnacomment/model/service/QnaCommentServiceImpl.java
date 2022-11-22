package com.jsg.house.qnacomment.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.house.exception.NoDataException;
import com.jsg.house.exception.NotChangeDataException;
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
	public List<Object> listQnaComment(int qnaId) {
		List<Object> commentList = null;
		try {
			commentList = mapper.listQnaComment(qnaId);
			if (commentList == null || commentList.isEmpty()) {
				throw new NoDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NoDataException();
		}
		return commentList;
	}

	@Override
	public void writeQnaComment(QnaComment comment) {
		int checkSum = 0;
		try {
			checkSum = mapper.writeQnaComment(comment);
			if (checkSum == 0) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NotChangeDataException();
		}
	}

	@Override
	public void modifyQnaComment(HashMap<String, Object> map) {
		int checkSum = 0;
		try {
			checkSum = mapper.modifyQnaComment(map);
			if (checkSum == 0) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NotChangeDataException();
		}
	}

	@Override
	public void deleteQnaComment(int id) {
		int checkSum = 0;
		try {
			checkSum = mapper.deleteQnaComment(id);
			if (checkSum == 0) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NotChangeDataException();
		}
	}

}
