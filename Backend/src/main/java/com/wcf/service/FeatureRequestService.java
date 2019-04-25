package com.wcf.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wcf.entity.Client;
import com.wcf.entity.FeatureRequest;
import com.wcf.entity.ProductArea;

@Service
public class FeatureRequestService {
	private static final Logger log = LoggerFactory.getLogger(FeatureRequestService.class);

	public List<FeatureRequest> getAllFeatureRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	public FeatureRequest getFeatureRequestByID(int featureRequestID) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Client> getClientList() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ProductArea> getProductAreaList() {
		// TODO Auto-generated method stub
		return null;
	}

	public void createFeatureRequest(FeatureRequest featureRequest) {
		// TODO Auto-generated method stub
		
	}

	public void updateFeatureRequest(FeatureRequest featureRequest) {
		// TODO Auto-generated method stub
		
	}

	public void deleteFeatureRequest(int featureRequestID) {
		// TODO Auto-generated method stub
		
	}
	
	private void updatePriorityFromAdd() {
		// TODO Auto-generated method stub
	}
	private void updatePriorityFromUpdate() {
		// TODO Auto-generated method stub
	}
	private void updatePriorityFromDelete() {
		// TODO Auto-generated method stub
	}

}
