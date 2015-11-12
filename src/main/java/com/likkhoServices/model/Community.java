/**
 *  Copyright (c) 2015 Likkho. All rights reserved.
 *
 */
package com.likkhoServices.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.google.gson.annotations.Expose;
import com.likkhoServices.displayObjects.CommunityDO;
import com.likkhoServices.displayObjects.DisplaybleObject;

@Entity
@Table(name = "ldb_community")
public class Community extends LikkhoModel {
	
	@Expose private String name;
	@Expose private String description;
	@Expose private String picURL;
	
	@Column(name = "community_moderator_id")
	@Expose private User moderator;
	
	@Expose private CommunityType type;
	@Expose private Date createdOn;
	
	// Relationships
	
	private Set<User> members;
	
	public Community() {
		super();
	}

	public Community(String name, String description, String picURL,
			User moderator, CommunityType type, Date createdOn) {
		super();
		this.name = name;
		this.description = description;
		this.picURL = picURL;
		this.moderator = moderator;
		this.type = type;
		this.createdOn = createdOn;
	}
	
	@Id
	@Column(name = "community_id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Override
	public int getId() {
		return this.id;
	}

	/**
	 * @return the name
	 */
	@Column(name = "community_name")
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
	@Column(name = "community_desc")
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
	@Column(name = "community_pic_url")
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
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "community_moderator_id")
	public User getModerator() {
		return moderator;
	}

	/**
	 * @param moderator the moderator to set
	 */
	public void setModerator(User moderator) {
		this.moderator = moderator;
	}

	/**
	 * @return the type
	 */
	@Column(name = "community_type")
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
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "community_created_on")
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	@Transient
	public DisplaybleObject getDisplayObject() {
		return new CommunityDO(this);
	}

	/**
	 * @return the members
	 * /
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ldb_community_followers", joinColumns = { 
			@JoinColumn(name = "community_id") 
		}, 
		inverseJoinColumns = { @JoinColumn(name = "community_id") 
	})
	public Set<User> getMembers() {
		return members;
	}

	/**
	 * @param members the members to set
	 * /
	public void setMembers(Set<User> members) {
		this.members = members;
	}
	*/
	
	
}
