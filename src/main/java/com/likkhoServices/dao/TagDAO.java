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

import com.likkhoServices.model.Tag;

@Repository("tagDao")
@Transactional(propagation = Propagation.REQUIRED)
public class TagDAO extends LikkhoDAO<Tag> {

	@Override
	protected Class<Tag> getMyClass() {
		return Tag.class;
	}

	public List<Tag> findByPredicate(Predicate predicate) {
		// TODO Auto-generated method stub
		return null;
	}
}
