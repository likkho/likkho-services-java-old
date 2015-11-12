/**
 *  Copyright (c) 2015 Likkho. All rights reserved.
 *
 */
package com.likkhoServices.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.likkhoServices.model.User;

@Repository("userDao")
@Transactional(propagation = Propagation.REQUIRED)
public class UserDAO extends LikkhoDAO<User> {

	protected Class<User> getMyClass(){
		return User.class;
	}

	public List<User> findByPredicate(Predicate predicate) {
		// TODO Auto-generated method stub
		return null;
	}
}
