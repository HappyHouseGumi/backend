package com.jsg.house.qnacomment.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QnA Comment : 댓글 정보", description = "댓글의 상세 정보를 나타낸다.")
public class QnaComment {
	
	@ApiModelProperty(value = "댓글번호")
	private int id;
	@ApiModelProperty(value = "글번호")
	private int qnaId;
	@ApiModelProperty(value = "작성자번호")
	private int userId;
	@ApiModelProperty(value = "댓글내용")
	private String content;
	@ApiModelProperty(value = "작성일")
	private String regDate;
	@ApiModelProperty(value = "댓글상태 (삭제여부)")
	private int state;
	
	public QnaComment() {
		super();
	}
	public QnaComment(int id, int qnaId, int userId, String content, String regDate, int state) {
		super();
		this.id = id;
		this.qnaId = qnaId;
		this.userId = userId;
		this.content = content;
		this.regDate = regDate;
		this.state = state;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQnaId() {
		return qnaId;
	}
	public void setQnaId(int qnaId) {
		this.qnaId = qnaId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", boardId=" + qnaId + ", userId=" + userId + ", content=" + content
				+ ", regDate=" + regDate + ", state=" + state + "]";
	}

}
