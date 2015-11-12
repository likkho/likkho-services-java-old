/**
 *  Copyright (c) 2015 Likkho. All rights reserved.
 *
 */
package com.likkhoServices.dao;

import java.util.List;

public interface DAO<T> {
	
	public T getById(Long id);
	
	public List<T> findByPredicate(Predicate predicate);
	
	public void addNew(T t);
	
	public void update(T t);
	
	public void remove(T t);
	
	public void flush();
}
