package com.wcf.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcf.dao.FeatureRequestDAO;
import com.wcf.entity.Client;
import com.wcf.entity.FeatureRequest;
import com.wcf.entity.ProductArea;

@Service
public class FeatureRequestService {
	private static final Logger log = LoggerFactory.getLogger(FeatureRequestService.class);
	
	@Autowired
	FeatureRequestDAO featureRequestDAO;

	public List<FeatureRequest> getAllFeatureRequests() {
		return featureRequestDAO.getAllFeatureRequests();
	}

	public FeatureRequest getFeatureRequestByID(int featureRequestID) {
		return featureRequestDAO.getFeatureRequestByID(featureRequestID);
	}

	public List<Client> getClientList() {
		return featureRequestDAO.getClientList();
	}

	public List<ProductArea> getProductAreaList() {
		return featureRequestDAO.getProductAreaList();
	}

	public void addFeatureRequest(FeatureRequest featureRequest) {
		if(doesFeatureRequestExistForClientAndPriority(featureRequest.getClient().getClientID(), featureRequest.getPriority())) {
			updatePriorityForAdd(featureRequest);
		}else{
			featureRequestDAO.createFeatureRequest(featureRequest);
		}
	}

	public void editFeatureRequest(FeatureRequest featureRequest) {
		// TODO Auto-generated method stub
		
	}

	public void removeFeatureRequest(int featureRequestID) {
		// TODO Auto-generated method stub
		
	}
	
	private void updatePriorityForAdd(FeatureRequest fr) {
		//Get all existing 
		//Find location of new one and insert into list
		//Remove all prior elements
		//reorder all priorities
		//upsert entire list
	}
	
	
	private void updatePriorityFromEdit() {
		// TODO Auto-generated method stub
	}
	private void updatePriorityFromRemove() {
		// TODO Auto-generated method stub
	}
	
	private boolean doesFeatureRequestExistForClientAndPriority(int clientID, int priority) {
		return !featureRequestDAO.getFeatureRequestByPriorityAndClient(clientID, priority).isEmpty();
	}

}
