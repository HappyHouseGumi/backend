package com.jsg.house.comment.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.house.comment.model.dto.Comment;
import com.jsg.house.comment.model.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService {
	
	private CommentMapper mapper;
	
	@Autowired
	public CommentServiceImpl(CommentMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<Object> listComment() throws Exception {
		return mapper.listComment();
	}

	@Override
	public int writeComment(Comment comment) throws Exception {
		return mapper.writeComment(comment);
	}

	@Override
	public int modifyComment(Comment comment) throws Exception {
		return mapper.modifyComment(comment);
	}

	@Override
	public int deleteComment(String commentId) throws Exception {
		return mapper.deleteComment(commentId);
	}

}
