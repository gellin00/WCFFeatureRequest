package com.wcf.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productarea")
public class ProductArea implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int areaID;
	
	@Column(name="areaname")
	private String areaName;
	
	
	public int getAreaID() {
		return areaID;
	}
	public void setAreaID(int areaID) {
		this.areaID = areaID;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	public ProductArea(int id, String name) {
		areaID = id;
		areaName = name;
	}
	public ProductArea() {
	}
	
}
