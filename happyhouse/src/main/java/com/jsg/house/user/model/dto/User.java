package com.jsg.house.user.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "User : 사용자정보", description = "사용자의 상세 정보를 나타낸다.")
public class User {
	@ApiModelProperty(value = "사용자 번호")
	private int id;
	@ApiModelProperty(value = "사용자 이메일")
	private String email;
	@ApiModelProperty(value = "사용자 pw")
	private String password;
	@ApiModelProperty(value = "사용자 닉네임")
	private String nickName;
	@ApiModelProperty(value = "등록일")
	private String regDate;
	@ApiModelProperty(value = "사용자 실주소")
	private String location;
	@ApiModelProperty(value = "사용자 등급")
	private int grade;
	@ApiModelProperty(value = "사용자 등급")
	private String oauth;
	
	public User() {	}

	public User(int id, String email, String password, String nickName, String regDate, String location,
			int grade, String oauth) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.nickName = nickName;
		this.email = email;
		this.regDate = regDate;
		this.location = location;
		this.grade = grade;
		this.oauth = oauth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getOauth() {
		return oauth;
	}

	public void setOauth(String oauth) {
		this.oauth = oauth;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", nickName=" + nickName + ", email="
				+ email + ", regDate=" + regDate + ", location=" + location + ", grade=" + grade +" ,oauth="+oauth+ "]";
	}
	
	
}
