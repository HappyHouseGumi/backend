package com.jsg.house.comment.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Comment : 댓글 정보", description = "댓글의 상세 정보를 나타낸다.")
public class Comment {
	
	@ApiModelProperty(value = "댓글번호")
	private int id;
	@ApiModelProperty(value = "글번호")
	private int boardId;
	@ApiModelProperty(value = "작성자 아이디")
	private int userId;
	@ApiModelProperty(value = "작성자 닉네임")
	private String nickName;
	@ApiModelProperty(value = "댓글내용")
	private String content;
	@ApiModelProperty(value = "작성일")
	private String regDate;
	@ApiModelProperty(value = "댓글상태 (삭제여부)")
	private int state;
	
	public Comment() {
		super();
	}
	public Comment(int id, int boardId, int userId, String nickName, String content, String regDate, int state) {
		super();
		this.id = id;
		this.boardId = boardId;
		this.userId = userId;
		this.nickName = nickName;
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
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
		return "Comment [id=" + id + ", boardId=" + boardId + ", userId=" + userId + ", nickName=" + nickName
				+ ", content=" + content + ", regDate=" + regDate + ", state=" + state + "]";
	}
	
}
