/**
 *  Copyright (c) 2015 Likkho. All rights reserved.
 *
 */
package com.likkhoServices.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likkhoServices.dao.DAO;
import com.likkhoServices.model.Tag;
import com.likkhoServices.service.TagService;

@Service
public class TagServiceImpl extends LikkhoServiceImpl implements TagService {

	private DAO<Tag> tagDAO;
	
	@Transactional
	public Tag tagById(final Long id) {
		return tagDAO.getById(id);
	}

	/**
	 * @return the tagDAO
	 */
	public DAO<Tag> getTagDAO() {
		return tagDAO;
	}

	/**
	 * @param tagDAO the tagDAO to set
	 */
	@Autowired
	public void setTagDAO(DAO<Tag> tagDAO) {
		this.tagDAO = tagDAO;
	}
}
