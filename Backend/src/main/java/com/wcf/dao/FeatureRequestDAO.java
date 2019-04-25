package com.wcf.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class FeatureRequestDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	
}
