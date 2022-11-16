package com.jsg.house.qnacomment.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.jsg.house.comment.model.dto.Comment;
import com.jsg.house.qnacomment.model.dto.QnaComment;

public interface QnaCommentService {

	List<Object> listQnaComment(int qnaId) throws Exception;

	int writeQnaComment(QnaComment comment) throws Exception;

	int modifyQnaComment(HashMap<String,Object> map) throws Exception;

	int deleteQnaComment(int id) throws Exception;

}
