package com.jsg.house.qnacomment.model.mapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.jsg.house.qnacomment.model.dto.QnaComment;

public interface QnaCommentMapper {

	List<Object> listQnaComment(int qnaId) throws SQLException;

	int writeQnaComment(QnaComment comment) throws SQLException;

	int modifyQnaComment(HashMap<String,Object> map) throws SQLException;

	int deleteQnaComment(int id) throws SQLException;

}
