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

import com.likkhoServices.model.Like;

@Repository("likeDao")
@Transactional(propagation = Propagation.REQUIRED)
public class LikeDAO extends LikkhoDAO<Like> {
	
	@Override
	protected Class<Like> getMyClass() {
		return Like.class;
	}

	public List<Like> findByPredicate(Predicate predicate) {
		// TODO Auto-generated method stub
		return null;
	}
}
