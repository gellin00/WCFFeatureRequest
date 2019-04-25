package com.wcf.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FeatureRequest {

	@Id
	@GeneratedValue
	private Long requestID;
	private String title;
	private String description;
	private Client client;
	private int priority;
	private Date targetDate;
	private ProductArea productArea;
	private String rowStatus;
	private Date createTimestamp;
	private Date lastUpdateTimestamp;
	
	public Long getRequestID() {
		return requestID;
	}
	public void setRequestID(Long requestID) {
		this.requestID = requestID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public ProductArea getProductArea() {
		return productArea;
	}
	public void setProductArea(ProductArea productArea) {
		this.productArea = productArea;
	}
	public String getRowStatus() {
		return rowStatus;
	}
	public void setRowStatus(String rowStatus) {
		this.rowStatus = rowStatus;
	}
	public Date getCreateTimestamp() {
		return createTimestamp;
	}
	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
	public Date getLastUpdateTimestamp() {
		return lastUpdateTimestamp;
	}
	public void setLastUpdateTimestamp(Date lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}
	
	
}
