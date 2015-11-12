/**
 *  Copyright (c) 2015 Likkho. All rights reserved.
 *
 */
package com.likkhoServices.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likkhoServices.dao.DAO;
import com.likkhoServices.model.Community;
import com.likkhoServices.service.CommunityService;

@Service
public class CommunityServiceImpl extends LikkhoServiceImpl 
implements CommunityService {

	private DAO<Community> communityDAO;
	
	@Transactional
	public Community communityById(final Long id) {
		return communityDAO.getById(id);
	}

	/**
	 * @return the communityDAO
	 */
	public DAO<Community> getCommunityDAO() {
		return communityDAO;
	}

	/**
	 * @param communityDAO the communityDAO to set
	 */
	@Autowired
	public void setCommunityDAO(DAO<Community> communityDAO) {
		this.communityDAO = communityDAO;
	}
}
