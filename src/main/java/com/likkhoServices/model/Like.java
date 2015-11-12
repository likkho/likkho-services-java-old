/**
 *  Copyright (c) 2015 Likkho. All rights reserved.
 *
 */
package com.likkhoServices.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.google.gson.annotations.Expose;
import com.likkhoServices.displayObjects.DisplaybleObject;
import com.likkhoServices.displayObjects.LikeDO;

@Entity
@Table(name = "ldb_likes")
public class Like extends LikkhoModel {
	
	@Expose private int postId;
	@Expose private int userId;
	@Expose private Date likedOn;
		
	public Like() {
		super();
	}

	public Like(int postId, int userId, Date likedOn) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.likedOn = likedOn;
	}
	
	@Id
	@Column(name = "like_id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Override
	public int getId() {
		return this.id;
	}

	/**
	 * @return the postId
	 */
	@Column(name = "post_id")
	public int getPostId() {
		return postId;
	}

	/**
	 * @param postId the postId to set
	 */
	public void setPostId(int postId) {
		this.postId = postId;
	}

	/**
	 * @return the userId
	 */
	@Column(name = "user_id")
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the likedOn
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "liked_on")
	public Date getLikedOn() {
		return likedOn;
	}

	/**
	 * @param likedOn the likedOn to set
	 */
	public void setLikedOn(Date likedOn) {
		this.likedOn = likedOn;
	}

	@Override
	@Transient
	public DisplaybleObject getDisplayObject() {
		return new LikeDO(this);
	}
}
