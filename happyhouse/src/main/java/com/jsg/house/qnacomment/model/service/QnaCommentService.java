package com.jsg.house.qnacomment.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.jsg.house.comment.model.dto.Comment;
import com.jsg.house.qnacomment.model.dto.QnaComment;

public interface QnaCommentService {

	List<Object> listQnaComment(int qnaId);

	void writeQnaComment(QnaComment comment);

	void modifyQnaComment(HashMap<String,Object> map);

	void deleteQnaComment(int id);

}
