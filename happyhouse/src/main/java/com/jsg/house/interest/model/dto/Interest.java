package com.jsg.house.interest.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Interest : 관심 지역 정보", description = "관심 지역 의 상세 정보를 나타낸다.")
public class Interest {
	@ApiModelProperty(value = "관심 글 번호")
	private int id;
	@ApiModelProperty(value = "사용자번호")
	private int userId;
	@ApiModelProperty(value = "동코드")
	private int dongCode;

	public Interest() {	}

	public Interest(int id, int userId, int dongCode) {
		super();
		this.id = id;
		this.userId = userId;
		this.dongCode = dongCode;
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

	public int getDongCode() {
		return dongCode;
	}

	public void setDongCode(int dongCode) {
		this.dongCode = dongCode;
	}

	@Override
	public String toString() {
		return "Interest [id=" + id + ", userId=" + userId + ", dongCode=" + dongCode + "]";
	}

}
