/**
 *  Copyright (c) 2015 Likkho. All rights reserved.
 *
 */
package com.likkhoServices.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.likkhoServices.model.Community;

@Repository("communityDao")
@Transactional(propagation = Propagation.REQUIRED)
public class CommunityDAO<T> extends LikkhoDAO<Community> {

	@Override
	protected Class<Community> getMyClass() {
		return Community.class;
	}

	public List<Community> findByPredicate(Predicate predicate) {
		// TODO Auto-generated method stub
		return null;
	}
}
