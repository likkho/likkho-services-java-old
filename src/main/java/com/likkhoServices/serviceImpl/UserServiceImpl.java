/**
 *  Copyright (c) 2015 Likkho. All rights reserved.
 *
 */
package com.likkhoServices.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likkhoServices.dao.DAO;
import com.likkhoServices.model.User;
import com.likkhoServices.service.UserService;

@Service
public class UserServiceImpl extends LikkhoServiceImpl implements UserService {

	private DAO<User> userDAO;
	
	@Transactional
	public User userById(final Long id) {
		User user = userDAO.getById(id);
		return user;
	}

	/**
	 * @return the userDAO
	 */
	public DAO<User> getUserDAO() {
		return userDAO;
	}

	/**
	 * @param userDAO the userDAO to set
	 */
	@Autowired
	public void setUserDAO(DAO<User> userDAO) {
		this.userDAO = userDAO;
	}
}
