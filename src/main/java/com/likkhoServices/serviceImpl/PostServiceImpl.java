/**
 *  Copyright (c) 2015 Likkho. All rights reserved.
 *
 */
package com.likkhoServices.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likkhoServices.dao.DAO;
import com.likkhoServices.model.Post;
import com.likkhoServices.service.PostService;

@Service
public class PostServiceImpl extends LikkhoServiceImpl implements PostService {

	private DAO<Post> postDAO;
	
	@Transactional
	public Post postById(final Long id) {
		return postDAO.getById(id);
	}
	
	/**
	 * @return the postDAO
	 */
	public DAO<Post> getPostDAO() {
		return postDAO;
	}

	/**
	 * @param postDAO the postDAO to set
	 */
	@Autowired
	public void setPostDAO(DAO<Post> postDAO) {
		this.postDAO = postDAO;
	}
}
