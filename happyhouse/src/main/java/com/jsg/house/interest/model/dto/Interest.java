package com.jsg.house.interest.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Interest : 관심 지역 정보", description = "관심 지역 의 상세 정보를 나타낸다.")
public class Interest {
	@ApiModelProperty(value = "관심 글 번호")
	private int id;
	@ApiModelProperty(value = "사용자번호")
	private int userId;
	@ApiModelProperty(value = "시도네임")
	private String sidoName;
	@ApiModelProperty(value = "구군임")
	private String gugunName;
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
	public String getSidoName() {
		return sidoName;
	}
	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}
	public String getGugunName() {
		return gugunName;
	}
	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}
	public Interest(int id, int userId, String sidoName, String gugunName) {
		super();
		this.id = id;
		this.userId = userId;
		this.sidoName = sidoName;
		this.gugunName = gugunName;
	}
	@Override
	public String toString() {
		return "Interest [id=" + id + ", userId=" + userId + ", sidoName=" + sidoName + ", gugunName=" + gugunName
				+ "]";
	}


}
