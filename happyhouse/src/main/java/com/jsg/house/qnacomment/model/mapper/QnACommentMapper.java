package com.jsg.house.qnacomment.model.mapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.jsg.house.qnacomment.model.dto.QnAComment;

public interface QnACommentMapper {

	List<Object> listQnAComment(int qnaId) throws SQLException;

	int writeQnAComment(QnAComment comment) throws SQLException;

	int modifyQnAComment(HashMap<String,Object> map) throws SQLException;

	int deleteQnAComment(int id) throws SQLException;

}
