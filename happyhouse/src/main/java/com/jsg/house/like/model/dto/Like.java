package com.jsg.house.like.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Like : 관심 글 정보", description = "관심 글 의 상세 정보를 나타낸다.")
public class Like {
	@ApiModelProperty(value = "글번호")
	private int boardId;
	@ApiModelProperty(value = "사용자번호")
	private int userId;
	@ApiModelProperty(value = "작성일")
	private String regDate;

	public Like() {
		super();
	}
	public Like(int boardId, int userId, String regDate) {
		super();
		this.boardId = boardId;
		this.userId = userId;
		this.regDate = regDate;
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
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Like [boardId=" + boardId + ", userId=" + userId + ", regDate=" + regDate + "]";
	}
	
}
