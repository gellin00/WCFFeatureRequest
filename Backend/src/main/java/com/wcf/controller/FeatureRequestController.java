package com.wcf.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wcf.entity.Client;
import com.wcf.entity.FeatureRequest;
import com.wcf.entity.ProductArea;
import com.wcf.service.FeatureRequestService;

@CrossOrigin
@RestController
@RequestMapping("/wcfFeatureRequest/api/rest")
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
	public ResponseEntity<?> addFeatureRequest(@RequestBody FeatureRequest featureRequest) {
		if(isValidFeatureRequest(featureRequest)) {
			featureReqService.addFeatureRequest(featureRequest);
			return ResponseEntity.ok(HttpStatus.OK);
		}else {
			return ResponseEntity.badRequest().body("Request object failed validation. A field was missing.");
		}
	}
	
	@PutMapping("/featureRequests")
	public ResponseEntity<?> editFeatureRequest(@RequestBody FeatureRequest featureRequest){
		if(isValidFeatureRequest(featureRequest)) {
			featureReqService.editFeatureRequest(featureRequest);
			return ResponseEntity.ok(HttpStatus.OK);
		}else {
			return ResponseEntity.badRequest().body("Request object failed validation. A field was missing.");
		}
		
	}
	
	@DeleteMapping("/featureRequests/{featureRequestID}")
	public ResponseEntity<?> removeFeatureRequest(@PathVariable int featureRequestID){
		featureReqService.removeFeatureRequest(featureRequestID);
		return ResponseEntity.ok(HttpStatus.OK);
		
	}
	
	@GetMapping("/test")
	public String testEndPoint() {
		return "Hey it worked";
	}
	
	private boolean isValidFeatureRequest(FeatureRequest fr) {
		return (fr != null 
				&& StringUtils.isNotBlank(fr.getTitle())
				&& StringUtils.isNotBlank(fr.getDescription())
				&& fr.getClient() != null
				&& fr.getClient().getClientID() > 0
				&& StringUtils.isNotBlank(fr.getClient().getClientName())
				&& fr.getPriority() > 0
				&& fr.getTargetDate() != null
				&& fr.getProductArea() != null
				&& fr.getProductArea().getAreaID() > 0
				&& StringUtils.isNotBlank(fr.getProductArea().getAreaName())
				&& StringUtils.isNotBlank(fr.getRowStatus())
				&& fr.getCreateTimestamp() != null);
		}
}
