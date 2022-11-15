package com.jsg.house.comment.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.jsg.house.comment.model.dto.Comment;

public interface CommentMapper {

	List<Object> listComment() throws SQLException;

	int writeComment(Comment comment) throws SQLException;

	int modifyComment(Comment comment) throws SQLException;

	int deleteComment(String commentId) throws SQLException;

}
