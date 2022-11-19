package com.jsg.house.comment.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.house.comment.model.dto.Comment;
import com.jsg.house.comment.model.mapper.CommentMapper;
import com.jsg.house.exception.NoDataException;
import com.jsg.house.exception.NotChangeDataException;

@Service
public class CommentServiceImpl implements CommentService {

	private CommentMapper mapper;

	@Autowired
	public CommentServiceImpl(CommentMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<Object> listComment(String boardId) {
		List<Object> commentList = null;
		try {
			commentList = mapper.listComment(boardId);
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
	public void writeComment(Comment comment) {
		int checkSum = 0;

		try {
			checkSum = mapper.writeComment(comment);
			if (checkSum == 0) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NotChangeDataException();
		}
	}

	@Override
	public void modifyComment(HashMap<String, Object> map) {
		int checkSum = 0;

		try {
			checkSum = mapper.modifyComment(map);
			if (checkSum == 0) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NotChangeDataException();
		}
	}

	@Override
	public void deleteComment(String commentId) {
		int checkSum = 0;

		try {
			checkSum = mapper.deleteComment(commentId);
			if (checkSum == 0) {
				throw new NotChangeDataException();
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new NotChangeDataException();
		}
	}

}
