package com.jsg.house.notice.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Notice : 공지사항정보", description = "공지사항의 상세 정보를 나타낸다.")
public class Notice {
	
	@ApiModelProperty(value = "글번호")
	private int id;
	@ApiModelProperty(value = "작성자 아이디")
	private int userId;
	@ApiModelProperty(value = "글제목")
	private String title;
	@ApiModelProperty(value = "글내용")
	private String content;
	@ApiModelProperty(value = "작성일")
	private String regDate;
	@ApiModelProperty(value = "글 상태 (삭제 여부")
	private int state;

	public Notice() {
		super();
	}
	public Notice(int id, int userId, String title, String content, String regDate, int state) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Notice [id=" + id + ", userId=" + userId + ", title=" + title + ", content=" + content + ", regDate="
				+ regDate + ", state=" + state + "]";
	}
	
}
