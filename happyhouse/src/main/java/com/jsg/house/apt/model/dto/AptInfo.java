package com.jsg.house.apt.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AptInfo : 아파트 정보", description = "아파트 정보의 상세 정보를 나타낸다.")
public class AptInfo {

	@ApiModelProperty(value = "아파트 코드 번호")
	private long aptcode;
	@ApiModelProperty(value = "아파트 건설 연도")
	private int buildYear;
	@ApiModelProperty(value = "주소")
	private String roadName;
	@ApiModelProperty(value = "아파트 이름")
	private String apartmentName;
	@ApiModelProperty(value = "위도")
	private String lat;
	@ApiModelProperty(value = "경도")
	private String lng;

	public AptInfo() {
		super();
	}
	public AptInfo(long aptcode, int buildYear, String roadName, String apartmentName, String lng, String lat) {
		super();
		this.aptcode = aptcode;
		this.buildYear = buildYear;
		this.roadName = roadName;
		this.apartmentName = apartmentName;
		this.lng = lng;
		this.lat = lat;
	}

	public long getAptcode() {
		return aptcode;
	}
	public void setAptcode(long aptcode) {
		this.aptcode = aptcode;
	}
	public int getBuildYear() {
		return buildYear;
	}
	public void setBuildYear(int buildYear) {
		this.buildYear = buildYear;
	}
	public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	public String getApartmentName() {
		return apartmentName;
	}
	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}

	@Override
	public String toString() {
		return "AptInfo [aptcode=" + aptcode + ", buildYear=" + buildYear + ", roadName=" + roadName
				+ ", apartmentName=" + apartmentName + ", lng=" + lng + ", lat=" + lat + "]";
	}

}
