package com.jsg.house.comment.model.service;

import java.util.HashMap;
import java.util.List;

import com.jsg.house.comment.model.dto.Comment;

public interface CommentService {

	List<Object> listComment(String boardId) throws Exception;

	int writeComment(Comment comment) throws Exception;
	
	int modifyComment(HashMap<String, Object> map) throws Exception;

	int deleteComment(String commentId) throws Exception;

}
