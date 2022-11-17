package com.jsg.house.like.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Like : 관심 글 정보", description = "관심 글 의 상세 정보를 나타낸다.")
public class Like {
	@ApiModelProperty(value = "관심 글 번호")
	private int id;
	@ApiModelProperty(value = "글번호")
	private int boardId;
	@ApiModelProperty(value = "사용자번호")
	private int userId;
	@ApiModelProperty(value = "관심 글 상태")
	private int state;
	
	public Like() {}
	public Like(int id, int boardId, int userId, int state) {
		super();
		this.id = id;
		this.boardId = boardId;
		this.userId = userId;
		this.state = state;
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Like [id=" + id + ", boardId=" + boardId + ", userId=" + userId + ", state=" + state + "]";
	}
	
}
