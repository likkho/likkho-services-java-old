/**
 *  Copyright (c) 2015 Likkho. All rights reserved.
 *
 */
package com.likkhoServices.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likkhoServices.dao.DAO;
import com.likkhoServices.model.Like;
import com.likkhoServices.service.LikeService;

@Service
public class LikeServiceImpl extends LikkhoServiceImpl implements LikeService {

	private DAO<Like> likeDAO;
	
	@Transactional
	public Like likeById(final Long id) {
		return likeDAO.getById(id);
	}

	/**
	 * @return the likeDAO
	 */
	public DAO<Like> getLikeDAO() {
		return likeDAO;
	}

	/**
	 * @param likeDAO the likeDAO to set
	 */
	@Autowired
	public void setLikeDAO(DAO<Like> likeDAO) {
		this.likeDAO = likeDAO;
	}
}
