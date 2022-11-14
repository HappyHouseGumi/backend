package com.jsg.house.notice.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Notice : 공지사항정보", description = "공지사항의 상세 정보를 나타낸다.")
public class Notice {
	
	@ApiModelProperty(value = "글번호")
	private int id;
	@ApiModelProperty(value = "작성자 아이디")
	private int userID;
	@ApiModelProperty(value = "글제목")
	private String title;
	@ApiModelProperty(value = "글내용")
	private String content;
	@ApiModelProperty(value = "작성일")
	private String regDate;
	
	public Notice() {
		super();
	}
	public Notice(int id, int userID, String title, String content, String regDate) {
		super();
		this.id = id;
		this.userID = userID;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
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
	
	@Override
	public String toString() {
		return "Notice [id=" + id + ", userID=" + userID + ", title=" + title + ", content=" + content + ", regDate="
				+ regDate + "]";
	}
	
}
