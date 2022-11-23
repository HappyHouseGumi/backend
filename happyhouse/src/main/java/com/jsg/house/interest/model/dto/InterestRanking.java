package com.jsg.house.interest.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Interest : 관심 지역 정보", description = "관심 지역 의 상세 정보를 나타낸다.")
public class InterestRanking {
	
	@ApiModelProperty(value = "동코드")
	private String dongCode;
	@ApiModelProperty(value = "시도")
	private String sidoName;
	@ApiModelProperty(value = "구군")
	private String gugunName;
	@ApiModelProperty(value = "좋아요 갯수")
	private int count;
	
	public InterestRanking() {
	}
	public InterestRanking(String dongCode, String sidoName, String gugunName, int count) {
		this.dongCode = dongCode;
		this.sidoName = sidoName;
		this.gugunName = gugunName;
		this.count = count;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "InterestRanking [dongCode=" + dongCode + ", sidoName=" + sidoName + ", gugunName=" + gugunName
				+ ", count=" + count + "]";
	}
	
}