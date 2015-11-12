/**
 *  Copyright (c) 2015 Likkho. All rights reserved.
 *
 */
package com.likkhoServices.displayObjects;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.likkhoServices.model.Like;

public class LikeDO extends DisplayObject implements DisplaybleObject {
	
	@Expose private int postId;
	@Expose private int userId;
	@Expose private Date likedOn;
	
	public LikeDO(Like like){
		super.setId(like.getId());
		this.postId = like.getPostId();
		this.userId = like.getUserId();
		this.likedOn = like.getLikedOn();
	}
}
