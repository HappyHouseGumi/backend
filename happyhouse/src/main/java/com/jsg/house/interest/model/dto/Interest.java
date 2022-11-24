package com.jsg.house.interest.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Interest : 관심 지역 정보", description = "관심 지역 의 상세 정보를 나타낸다.")
public class Interest {
	@ApiModelProperty(value = "사용자번호")
	private int userId;
	@ApiModelProperty(value = "동코드")
	private String dongCode;
	@ApiModelProperty(value = "시도")
	private String sidoName;
	@ApiModelProperty(value = "구군")
	private String gugunName;

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
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
	public Interest(int userId, String dongCode, String sidoName, String gugunName) {
		super();
		this.userId = userId;
		this.dongCode = dongCode;
		this.sidoName = sidoName;
		this.gugunName = gugunName;
	}
	@Override
	public String toString() {
		return "Interest [userId=" + userId + ", dongCode=" + dongCode + ", sidoName=" + sidoName
				+ ", gugunName=" + gugunName + "]";
	}

	

}
