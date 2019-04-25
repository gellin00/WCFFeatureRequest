package com.wcf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wcf.entity.Client;
import com.wcf.entity.FeatureRequest;
import com.wcf.entity.ProductArea;
import com.wcf.service.FeatureRequestService;

@RestController
public class FeatureRequestController {
	@Autowired
	FeatureRequestService featureReqService;

	@GetMapping("/featureRequests")
	@ResponseBody
	public List<FeatureRequest> fetchAllFeatureRequests(){
		return featureReqService.getAllFeatureRequests();
	}
	
	@GetMapping("/featureRequests/{featureRequestID}")
	@ResponseBody
	public FeatureRequest fetchFeatureRequest(@PathVariable int featureRequestID) {
		return featureReqService.getFeatureRequestByID(featureRequestID);
	}
	
	@GetMapping("/clients")
	@ResponseBody
	public List<Client> fetchClientList(){
		return featureReqService.getClientList();
	}
	
	@GetMapping("/productAreas")
	@ResponseBody
	public List<ProductArea> fetchProductAreaList(){
		return featureReqService.getProductAreaList();
	}
	
	@PostMapping("/featureRequests")
	public ResponseEntity<?> createFeatureRequest(@RequestBody FeatureRequest featureRequest) {
		featureReqService.createFeatureRequest(featureRequest);
		//TODO add error handling after writing service layer
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@PutMapping("/featureRequests")
	public ResponseEntity<?> updateFeatureRequest(@RequestBody FeatureRequest featureRequest){
		featureReqService.updateFeatureRequest(featureRequest);
		//TODO add error handling after writing service later
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@DeleteMapping("/featureRequests/{featureRequestID}")
	public ResponseEntity<?> deleteFeatureRequest(@PathVariable int featureRequestID){
		featureReqService.deleteFeatureRequest(featureRequestID);
		//TODO add error handling after writing service later
		return ResponseEntity.ok(HttpStatus.OK);
	}
}
