package com.jsg.house.qna.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QnA : QnA정보", description = "QnA의 상세 정보를 나타낸다.")
public class Qna {

	@ApiModelProperty(value = "글번호")
	private int id;
	@ApiModelProperty(value = "작성자 이름")
	private String userName;
	@ApiModelProperty(value = "작성자 비밀번호")
	private String password;
	
	@ApiModelProperty(value = "글제목")
	private String title;
	@ApiModelProperty(value = "글내용")
	private String content;
	@ApiModelProperty(value = "작성일")
	private String regDate;
	public Qna(int id, String userName, String password,String title, String content, String regDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "QnA [id=" + id + ", userName=" + userName + ", title=" + title + ", content=" + content + ", regDate="
				+ regDate + "]";
	}
	
	
	
}
