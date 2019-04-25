package com.wcf.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.wcf.entity.Client;
import com.wcf.entity.FeatureRequest;
import com.wcf.entity.ProductArea;

@Repository
public class FeatureRequestDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<FeatureRequest> getAllFeatureRequests() {
		String q = "FROM FeatureRequest F WHERE F.rowStatus = 'A' ORDER BY F.requestID ASC";
		Query query = entityManager.createQuery(q);
		return query.getResultList();
	}

	public FeatureRequest getFeatureRequestByID(int featureRequestID) {
		return entityManager.find(FeatureRequest.class, featureRequestID);
	}

	@SuppressWarnings("unchecked")
	public List<Client> getClientList() {
		String q = "FROM Client C ORDER BY C.clientID ASC";
		Query query = entityManager.createQuery(q);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ProductArea> getProductAreaList() {
		String q = "FROM ProductArea P ORDER BY areaID ASC";
		Query query = entityManager.createQuery(q);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<FeatureRequest> getAllFeatureRequestsByClient(int clientID){
		String q = "FROM FeatureRequest F WHERE F.rowStatus = 'A' AND F.clientID = :clientid ORDER BY F.priority ASC";
		Query query = entityManager.createQuery(q);
		query.setParameter("clientID", clientID);
		return query.getResultList();
	}
	
	public void softDeleteFeatureRequest(int reqID) {
		String q = "UPDATE FeatureRequest F SET F.rowStatus = 'I' WHERE F.requestID = :rowID";
		Query query = entityManager.createQuery(q);
		query.setParameter("rowID", reqID);
		query.executeUpdate();
	}
	
	public void createFeatureRequest(FeatureRequest req) {
		entityManager.persist(req);
	}
	
	public void updateFeatureRequest(FeatureRequest req) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(req);
	}
	
	@SuppressWarnings("unchecked")
	public List<FeatureRequest> getFeatureRequestByPriorityAndClient(int clientID, int priority) {
		String q = "FROM FeatureRequest F WHERE F.clientID = :clientID AND F.priority = :pri";
		Query query = entityManager.createQuery(q);
		query.setParameter("clientID", clientID);
		query.setParameter("pri", priority);
		
		return query.getResultList();
	}
	
	
}
