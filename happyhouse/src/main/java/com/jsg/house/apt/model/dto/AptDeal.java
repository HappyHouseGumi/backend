package com.jsg.house.apt.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AptDeal : 아파트 매매", description = "아파트 매매의 상세 정보를 나타낸다.")
public class AptDeal {

	@ApiModelProperty(value = "아파트 매매 식별 번호")
	private long no;
	@ApiModelProperty(value = "매매양")
	private String dealAmount;
	@ApiModelProperty(value = "매매년도")
	private int dealYear;
	@ApiModelProperty(value = "매매월")
	private int dealMonth;
	@ApiModelProperty(value = "매매일")
	private int dealDay;
	@ApiModelProperty(value = "지역")
	private String area;
	@ApiModelProperty(value = "층")
	private String floor;
	@ApiModelProperty(value = "아파트 코드")
	private long aptCode;
	
	public AptDeal() {
		super();
	}
	public AptDeal(long no, String dealAmount, int dealYear, int dealMonth, int dealDay, String area, String floor,
			long aptCode) {
		super();
		this.no = no;
		this.dealAmount = dealAmount;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealDay = dealDay;
		this.area = area;
		this.floor = floor;
		this.aptCode = aptCode;
	}
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public int getDealYear() {
		return dealYear;
	}
	public void setDealYear(int dealYear) {
		this.dealYear = dealYear;
	}
	public int getDealMonth() {
		return dealMonth;
	}
	public void setDealMonth(int dealMonth) {
		this.dealMonth = dealMonth;
	}
	public int getDealDay() {
		return dealDay;
	}
	public void setDealDay(int dealDay) {
		this.dealDay = dealDay;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public long getAptCode() {
		return aptCode;
	}
	public void setAptCode(long aptCode) {
		this.aptCode = aptCode;
	}
	@Override
	public String toString() {
		return "AptDeal [no=" + no + ", dealAmount=" + dealAmount + ", dealYear=" + dealYear + ", dealMonth="
				+ dealMonth + ", dealDay=" + dealDay + ", area=" + area + ", floor=" + floor + ", aptCode=" + aptCode
				+ "]";
	}
	
}
