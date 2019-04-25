package com.wcf.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProductArea {

	@Id
	@GeneratedValue
	private Long areaID;
	private String areaName;
	
	
	public Long getAreaID() {
		return areaID;
	}
	public void setAreaID(Long areaID) {
		this.areaID = areaID;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	
}
