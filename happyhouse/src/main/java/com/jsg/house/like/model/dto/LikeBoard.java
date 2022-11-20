package com.jsg.house.like.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "LikeBoard : 관심 글 정보 상세 데이터", description = "관심 글 의 상세 정보를 나타낸다.")
public class LikeBoard {
	@ApiModelProperty(value = "관심 글 번호")
	private int id;
	@ApiModelProperty(value = "글번호")
	private int boardId;
	@ApiModelProperty(value = "사용자번호")
	private int userId;
	@ApiModelProperty(value = "글 작성자 닉네임")
	private String nickName;
	@ApiModelProperty(value = "글분류")
	private String subject;
	@ApiModelProperty(value = "글제목")
	private String title;
	
	public LikeBoard() {
		super();
	}
	public LikeBoard(int id, int boardId, int userId, String nickName, String subject, String title) {
		super();
		this.id = id;
		this.boardId = boardId;
		this.userId = userId;
		this.nickName = nickName;
		this.subject = subject;
		this.title = title;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "LikeBoard [id=" + id + ", boardId=" + boardId + ", userId=" + userId + ", nickName=" + nickName
				+ ", subject=" + subject + ", title=" + title + "]";
	}
	
}
