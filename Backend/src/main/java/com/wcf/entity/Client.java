package com.wcf.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client {

	@Id
	@GeneratedValue
	private Long clientID;
	private String clientName;
	
	public Long getClientID() {
		return clientID;
	}
	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
}
