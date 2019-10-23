package com.template.app.rest.service.company;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.template.app.entity.CompanyEntity;


@Stateless
public class CompanyService {
	
	@PersistenceContext(unitName = "company-persistence-unit")
	private EntityManager entityManater;

	public List<CompanyEntity> GetAllCompanies() {
		
		//entityManater.createNamedQuery("CompanyEntity.retrieveAll").getResultList();
		
		List<CompanyEntity> listCompanies = entityManater.createNamedQuery("CompanyEntity.retrieveAll").getResultList();
				
				//entityManater.createQuery("from CompanyEntity").getResultList();
		return listCompanies;
	}

	public CompanyEntity create(CompanyEntity entityCompany) {
		entityManater.persist(entityCompany);
		return entityCompany;
	}

	public void delete(CompanyEntity entity) {	
		entityManater.remove(entityManater.contains(entity) ? entity : entityManater.merge(entity));
	}
}
