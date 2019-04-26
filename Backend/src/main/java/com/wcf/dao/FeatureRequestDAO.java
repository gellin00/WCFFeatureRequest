package com.wcf.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wcf.entity.Client;
import com.wcf.entity.FeatureRequest;
import com.wcf.entity.ProductArea;

@Repository
public class FeatureRequestDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Transactional
	public List<FeatureRequest> getAllFeatureRequests() {
		String q = "FROM FeatureRequest F WHERE F.rowStatus = 'A' ORDER BY F.requestID ASC";
		Query query = entityManager.createQuery(q);
		return query.getResultList();
	}

	@Transactional
	public FeatureRequest getFeatureRequestByID(int featureRequestID) {
		return entityManager.find(FeatureRequest.class, featureRequestID);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Client> getClientList() {
		String q = "FROM Client C ORDER BY C.clientID ASC";
		Query query = entityManager.createQuery(q);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<ProductArea> getProductAreaList() {
		String q = "FROM ProductArea P ORDER BY areaID ASC";
		Query query = entityManager.createQuery(q);
		return query.getResultList();
	}
	
	private final String SELECT_FEATUREREQUEST_BY_CLIENT_QUERY =
			"SELECT F.requestID, F.title, F.description, F.clientID, C.clientName, F.priority, F.targetDate, F.areaID, A.areaName, F.rowStatus, F.createTimestamp " +
			"FROM FeatureRequest F JOIN Client C ON F.clientID = C.clientID " +
			"JOIN ProductArea A ON F.areaID = A.areaID " +
			"WHERE F.rowStatus = 'A' AND C.clientID = :cid "+
			"ORDER BY F.priority ASC ";
	@SuppressWarnings("unchecked")
	@Transactional
	public List<FeatureRequest> getAllFeatureRequestsByClient(int clientID){
		Query query = entityManager.createNativeQuery(SELECT_FEATUREREQUEST_BY_CLIENT_QUERY);
		query.setParameter("cid", clientID);

		List<Object[]> results = query.getResultList();
		List<FeatureRequest> reqList = new ArrayList<FeatureRequest>();
		
		for(Object[] row : results) {
			FeatureRequest fr = new FeatureRequest();
			fr.setRequestID((int) row[0]);
			fr.setTitle((String) row[1]);
			fr.setDescription((String) row[2]);
			fr.setClient(new Client((int) row[3], (String) row[4]));
			fr.setPriority((int) row[5]);
			fr.setTargetDate((Date) row[6]);
			fr.setProductArea(new ProductArea((int) row[7], (String) row[8]));
			fr.setRowStatus((String) row[9]);
			fr.setCreateTimestamp((Date) row[10]);
			reqList.add(fr);
		}
		
		return reqList;
	}
	
	@Transactional
	public void softDeleteFeatureRequest(int reqID) {
		String q = "UPDATE FeatureRequest F SET F.rowStatus = 'I' WHERE F.requestID = :rowID";
		Query query = entityManager.createQuery(q);
		query.setParameter("rowID", reqID);
		query.executeUpdate();
	}
	
	@Transactional
	public void createFeatureRequest(FeatureRequest req) {
		entityManager.persist(req);
	}
	
	@Transactional
	public void updateFeatureRequest(FeatureRequest req) {
		entityManager.merge(req);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<FeatureRequest> getFeatureRequestByPriorityAndClient(int clientID, int priority) {
		String q = "SELECT F FROM FeatureRequest F INNER JOIN F.client C WHERE C.clientID = :cID AND F.priority = :pri AND F.rowStatus = 'A'";
		Query query = entityManager.createQuery(q, FeatureRequest.class);
		query.setParameter("cID", clientID);
		query.setParameter("pri", priority);
		
		return query.getResultList();
	}
}
