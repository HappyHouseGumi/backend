package com.jsg.house.comment.model.service;

import java.util.HashMap;
import java.util.List;

import com.jsg.house.comment.model.dto.Comment;

public interface CommentService {

	List<Object> listComment(String boardId);

	void writeComment(Comment comment);
	
	void modifyComment(HashMap<String, Object> map);

	void deleteComment(String commentId);

}
