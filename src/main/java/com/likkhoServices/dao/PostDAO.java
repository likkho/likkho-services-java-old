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

import com.likkhoServices.model.Post;

@Repository("postDao")
@Transactional(propagation = Propagation.REQUIRED)
public class PostDAO extends LikkhoDAO<Post> {

	@Override
	protected Class<Post> getMyClass() {
		return Post.class;
	}

	public List<Post> findByPredicate(Predicate predicate) {
		// TODO Auto-generated method stub
		return null;
	}
}
