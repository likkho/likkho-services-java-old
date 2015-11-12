/**
 *  Copyright (c) 2015 Likkho. All rights reserved.
 *
 */
package com.likkhoServices.displayObjects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DisplayObject implements DisplaybleObject {
	
	private int id;

	/**
	 * @return the id
	 */
	@JsonProperty
	protected int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	protected void setId(int id) {
		this.id = id;
	}
}
