package com.wcf.service;

import java.util.ArrayList;
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
			createFeatureRequestWithPriorityUpdate(featureRequest);
		}else{
			featureRequestDAO.createFeatureRequest(featureRequest);
		}
	}

	public void editFeatureRequest(FeatureRequest fr) {
		FeatureRequest existing = featureRequestDAO.getFeatureRequestByID(fr.getRequestID());
		if(existing.getPriority() == fr.getPriority()) {
			featureRequestDAO.updateFeatureRequest(fr);
		}else {
			updateFeatureRequestWithPriorityUpdate(fr);
		}
	}

	public void removeFeatureRequest(int featureRequestID) {
		FeatureRequest fr = featureRequestDAO.getFeatureRequestByID(featureRequestID);
		List<FeatureRequest> reqList = featureRequestDAO.getAllFeatureRequestsByClient(fr.getClient().getClientID());
		
		//Remove first before any other updates
		featureRequestDAO.softDeleteFeatureRequest(featureRequestID);
		
		int frIndex = -1;
		for(int i = 0 ; i < reqList.size() ; i++) {
			if(fr.getRequestID() == reqList.get(i).getRequestID()) {
				frIndex = i;
				break;
			}
		}
		
		if(frIndex != -1) {
			reqList.remove(frIndex);
			if(frIndex != 0) {
				reqList.subList(0, frIndex).clear();
			}
			for(FeatureRequest r : reqList) {
				r.setPriority(r.getPriority() - 1);
				featureRequestDAO.updateFeatureRequest(r);
			}
			
		}
	}
	
	private void createFeatureRequestWithPriorityUpdate(FeatureRequest fr) {
		List<FeatureRequest> reqList = new ArrayList<FeatureRequest>(featureRequestDAO.getAllFeatureRequestsByClient(fr.getClient().getClientID()));
		
		prepareFeatureRequstListForPriorityUpdate(reqList, fr);

		for(FeatureRequest req : reqList) {
			featureRequestDAO.updateFeatureRequest(req);
		}
	}
	
	private void updateFeatureRequestWithPriorityUpdate(FeatureRequest fr) {
		List<FeatureRequest> reqList = new ArrayList<FeatureRequest>(featureRequestDAO.getAllFeatureRequestsByClient(fr.getClient().getClientID()));
		
		reqList.removeIf(x -> fr.getRequestID() == x.getRequestID());
		
		prepareFeatureRequstListForPriorityUpdate(reqList, fr);
		
		for(FeatureRequest req : reqList) {
			featureRequestDAO.updateFeatureRequest(req);
		}
	}

	private boolean doesFeatureRequestExistForClientAndPriority(int clientID, int priority) {
		return !featureRequestDAO.getFeatureRequestByPriorityAndClient(clientID, priority).isEmpty();
	}
	
	private void prepareFeatureRequstListForPriorityUpdate(List<FeatureRequest> reqList, FeatureRequest fr){
		//Find where new item fits into the list and add it
		int i = 0;
		for( ; i < reqList.size() ; i++) {
			if(fr.getPriority() == reqList.get(i).getPriority()) {
				break;
			}
		}
		reqList.add(i, fr);
		
		//Remove all prior elements
		if(i != 0) {
			reqList.subList(0, i).clear();
		}
		
		//reorder all priorities
		int curPriority = fr.getPriority();
		for(int k = 0 ; k < reqList.size() ; k++) {
			reqList.get(k).setPriority(curPriority);
			curPriority++;
		}
	}

}
