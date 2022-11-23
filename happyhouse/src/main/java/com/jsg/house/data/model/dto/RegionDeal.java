package com.jsg.house.data.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RegionDeal : 지역별 연도별 평균 매매가", description = "지역별 연도별 평균 매매가를 나타낸다.")
public class RegionDeal {

	@ApiModelProperty(value = "시도 이름")
	private String sidoName;
	@ApiModelProperty(value = "연도")
	private int dealYear;
	@ApiModelProperty(value = "매매가")
	private String dealAmount;
	
	public RegionDeal() {
		super();
	}
	public RegionDeal(String sidoName, int dealYear, String dealAmount) {
		super();
		this.sidoName = sidoName;
		this.dealYear = dealYear;
		this.dealAmount = dealAmount;
	}
	
	public String getSidoName() {
		return sidoName;
	}
	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}
	public int getDealYear() {
		return dealYear;
	}
	public void setDealYear(int dealYear) {
		this.dealYear = dealYear;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	
	@Override
	public String toString() {
		return "RegionDeal [sidoName=" + sidoName + ", dealYear=" + dealYear + ", dealAmount=" + dealAmount + "]";
	}
	
}