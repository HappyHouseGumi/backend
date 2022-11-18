package com.jsg.house.board.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Board : 게시글 말머리 정보", description = "게시글 말머리의 상세 정보를 나타낸다.")
public class BoardSubject {
	
	@ApiModelProperty(value = "시도 식별용 코드")
	private int id;
	@ApiModelProperty(value = "시도 이름")
	private String sidoName;
	@ApiModelProperty(value = "구군 이름")
	private String gugunName;
	
	public BoardSubject() {
		super();
	}
	public BoardSubject(int id, String sidoName, String gugunName) {
		super();
		this.sidoName = sidoName;
		this.gugunName = gugunName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "BoardSubject [id=" + id + ", sidoName=" + sidoName + ", gugunName=" + gugunName + "]";
	}
	
}
