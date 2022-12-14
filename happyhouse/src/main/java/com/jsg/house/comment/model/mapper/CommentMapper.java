package com.jsg.house.comment.model.mapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.jsg.house.comment.model.dto.Comment;

public interface CommentMapper {

	List<Object> listComment(String boardId) throws SQLException;

	int writeComment(Comment comment) throws SQLException;

	int modifyComment(HashMap<String, Object> map) throws SQLException;

	int deleteComment(String commentId) throws SQLException;

}
