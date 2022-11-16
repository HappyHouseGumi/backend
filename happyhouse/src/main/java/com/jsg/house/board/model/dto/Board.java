package com.jsg.house.board.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Board : 게시글정보", description = "게시글의 상세 정보를 나타낸다.")
public class Board {

	@ApiModelProperty(value = "글번호")
	private int id;
	@ApiModelProperty(value = "작성자 아이디")
	private int userID;
	@ApiModelProperty(value = "글분류")
	private String subject;
	@ApiModelProperty(value = "글제목")
	private String title;
	@ApiModelProperty(value = "글내용")
	private String content;
	@ApiModelProperty(value = "작성일")
	private String regDate;
	@ApiModelProperty(value = "조회수")
	private int hit;
	@ApiModelProperty(value = "글상태 (삭제여부)")
	private int state;
	
	public Board() {
		super();
	}
	public Board(int id, int userID, String subject, String title, String content, String regDate, int hit, int state) {
		super();
		this.id = id;
		this.userID = userID;
		this.subject = subject;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.hit = hit;
		this.state = state;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
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
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Board [id=" + id + ", userID=" + userID + ", subject=" + subject + ", title=" + title + ", content="
				+ content + ", regDate=" + regDate + ", hit=" + hit + ", state=" + state + "]";
	}
	
}
