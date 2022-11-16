package com.jsg.house.qnacomment.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.jsg.house.comment.model.dto.Comment;
import com.jsg.house.qnacomment.model.dto.QnAComment;

public interface QnACommentService {

	List<Object> listQnAComment(int qnaId) throws Exception;

	int writeQnAComment(QnAComment comment) throws Exception;

	int modifyQnAComment(HashMap<String,Object> map) throws Exception;

	int deleteQnAComment(int id) throws Exception;

}
