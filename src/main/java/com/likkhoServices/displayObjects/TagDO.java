/**
 *  Copyright (c) 2015 Likkho. All rights reserved.
 *
 */
package com.likkhoServices.displayObjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.likkhoServices.model.Tag;

public class TagDO extends DisplayObject implements DisplaybleObject {
	@Expose private String name;
	@Expose private long rank;
	
	public TagDO(Tag tag){
		super.setId(tag.getId());
		this.name = tag.getName();
		this.rank = tag.getRank();
	}

	/**
	 * @return the name
	 */
	@JsonProperty
	protected String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	protected void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the rank
	 */
	@JsonProperty
	protected long getRank() {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	protected void setRank(long rank) {
		this.rank = rank;
	}
}
