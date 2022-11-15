package com.jsg.house.comment.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Comment : 댓글 정보", description = "댓글의 상세 정보를 나타낸다.")
public class Comment {
	
	@ApiModelProperty(value = "댓글번호")
	private int id;
	@ApiModelProperty(value = "글번호")
	private int boardId;
	@ApiModelProperty(value = "작성자번호")
	private int userId;
	@ApiModelProperty(value = "댓글내용")
	private String content;
	@ApiModelProperty(value = "작성일")
	private String regDate;
	
	public Comment() {
		super();
	}
	public Comment(int id, int boardId, int userId, String content, String regDate) {
		super();
		this.id = id;
		this.boardId = boardId;
		this.userId = userId;
		this.content = content;
		this.regDate = regDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
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
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", boardId=" + boardId + ", userId=" + userId + ", content=" + content
				+ ", regDate=" + regDate + "]";
	}

}
