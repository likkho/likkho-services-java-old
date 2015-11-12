/**
 *  Copyright (c) 2015 Likkho. All rights reserved.
 *
 */
package com.likkhoServices.model;

import javax.persistence.Column;

import com.likkhoServices.displayObjects.DisplaybleObject;

public abstract class LikkhoModel {
	
	protected int id;
	protected boolean isActive = true;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the isActive
	 */
	@Column(name = "is_active")
	public boolean isActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public abstract DisplaybleObject getDisplayObject();
}
