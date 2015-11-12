/**
 *  Copyright (c) 2015 Likkho. All rights reserved.
 *
 */
package com.likkhoServices.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class LikkhoDAO<T> implements DAO<T> {
	
	@PersistenceContext
	private EntityManager entityManager;
	 
	public EntityManager getEntityManager() {
		return entityManager;
	}
	 
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	protected abstract Class<T> getMyClass();
	
	public T getById(Long id) {
		T t = (T) this.entityManager.find(this.getMyClass(), id.intValue());
	    return t;
	}
	
	public void addNew(T t) {
	    this.entityManager.persist(t);
	}
	
	public void update(T t) {
	    this.entityManager.refresh(t);
	}
	
	public void remove(T t) {
	    this.entityManager.remove(t);
	}
	
	public void flush(){
		this.entityManager.flush();
	}
}
