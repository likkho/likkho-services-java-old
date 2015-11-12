/**
 *  Copyright (c) 2015 Likkho. All rights reserved.
 *
 */
package com.likkhoServices.displayObjects;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.likkhoServices.model.Community;
import com.likkhoServices.model.CommunityType;

public class CommunityDO extends DisplayObject implements DisplaybleObject {

	@Expose private String name;
	@Expose private String description;
	@Expose private String picURL;
	
	@Expose private UserDO moderator;
	
	@Expose private CommunityType type;
	@Expose private Date createdOn;
	
	public CommunityDO(Community community){
		super.setId(community.getId());
		this.name = community.getName();
		this.description = community.getDescription();
		this.picURL = community.getPicURL();
		this.moderator = new UserDO(community.getModerator());
		this.type = community.getType();
		this.createdOn = community.getCreatedOn();
	}
	
	/**
	 * @return the name
	 */
	@JsonProperty
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	@JsonProperty
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the picURL
	 */
	@JsonProperty
	public String getPicURL() {
		return picURL;
	}
	/**
	 * @param picURL the picURL to set
	 */
	public void setPicURL(String picURL) {
		this.picURL = picURL;
	}
	/**
	 * @return the moderator
	 */
	@JsonProperty
	public UserDO getModerator() {
		return moderator;
	}
	/**
	 * @param moderator the moderator to set
	 */
	public void setModerator(UserDO moderator) {
		this.moderator = moderator;
	}
	/**
	 * @return the type
	 */
	@JsonProperty
	public CommunityType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(CommunityType type) {
		this.type = type;
	}
	/**
	 * @return the createdOn
	 */
	@JsonProperty
	public Date getCreatedOn() {
		return createdOn;
	}
	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}	
}
