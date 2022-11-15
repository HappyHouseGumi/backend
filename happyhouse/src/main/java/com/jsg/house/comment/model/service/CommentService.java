package com.jsg.house.comment.model.service;

import java.util.List;

import com.jsg.house.comment.model.dto.Comment;

public interface CommentService {

	List<Object> listComment() throws Exception;

	int writeComment(Comment comment) throws Exception;
	
	int modifyComment(Comment comment) throws Exception;

	int deleteComment(String commentId) throws Exception;

}
