/**
 *  Copyright (c) 2015 Likkho. All rights reserved.
 *
 */
package com.likkhoServices.displayObjects;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.likkhoServices.model.Comment;
import com.likkhoServices.model.Community;
import com.likkhoServices.model.Post;
import com.likkhoServices.model.PostStatus;
import com.likkhoServices.model.PostType;
import com.likkhoServices.model.Tag;
import com.likkhoServices.model.User;

public class PostDO extends DisplayObject implements DisplaybleObject, Serializable {
	
	private String title;
	private String text;
	private String mediaURL;
	private String postURL;
	private PostType type;
	private UserDO author;
	private PostStatus status;
	private CommunityDO community;
	private String referenceURL;
	private Date createdOn;
	private int numMinutesToRead;
	private boolean isPrivate;
	
	private Set<CommentDO> comments = new HashSet<CommentDO>();
	private Set<TagDO> tags = new HashSet<TagDO>();
	
	public PostDO(Post post){
		super.setId(post.getId());
		this.title = post.getTitle();
		this.text = post.getText();
		this.mediaURL = post.getMediaURL();
		this.postURL = post.getPostURL();
		this.type = post.getType();
		this.author = new UserDO(post.getAuthor());
		this.status = post.getStatus();
		this.community = new CommunityDO(post.getCommunity());
		this.referenceURL = post.getReferenceURL();
		this.createdOn = post.getCreatedOn();
		this.numMinutesToRead = post.getNumMinutesToRead();
		this.isPrivate = post.isPrivate();
	}
	
	/**
	 * @return the title
	 */
	@JsonProperty
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the text
	 */
	@JsonProperty
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the mediaURL
	 */
	@JsonProperty
	public String getMediaURL() {
		return mediaURL;
	}
	/**
	 * @param mediaURL the mediaURL to set
	 */
	public void setMediaURL(String mediaURL) {
		this.mediaURL = mediaURL;
	}
	/**
	 * @return the postURL
	 */
	@JsonProperty
	public String getPostURL() {
		return postURL;
	}
	/**
	 * @param postURL the postURL to set
	 */
	public void setPostURL(String postURL) {
		this.postURL = postURL;
	}
	/**
	 * @return the type
	 */
	@JsonProperty
	public PostType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(PostType type) {
		this.type = type;
	}
	/**
	 * @return the author
	 */
	@JsonProperty
	public UserDO getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(UserDO author) {
		this.author = author;
	}
	/**
	 * @return the status
	 */
	@JsonProperty
	public PostStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(PostStatus status) {
		this.status = status;
	}
	/**
	 * @return the community
	 */
	@JsonProperty
	public CommunityDO getCommunity() {
		return community;
	}
	/**
	 * @param community the community to set
	 */
	public void setCommunity(CommunityDO community) {
		this.community = community;
	}
	/**
	 * @return the referenceURL
	 */
	@JsonProperty
	public String getReferenceURL() {
		return referenceURL;
	}
	/**
	 * @param referenceURL the referenceURL to set
	 */
	public void setReferenceURL(String referenceURL) {
		this.referenceURL = referenceURL;
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
	/**
	 * @return the numMinutesToRead
	 */
	@JsonProperty
	public int getNumMinutesToRead() {
		return numMinutesToRead;
	}
	/**
	 * @param numMinutesToRead the numMinutesToRead to set
	 */
	public void setNumMinutesToRead(int numMinutesToRead) {
		this.numMinutesToRead = numMinutesToRead;
	}
	/**
	 * @return the isPrivate
	 */
	@JsonProperty
	public boolean isPrivate() {
		return isPrivate;
	}
	/**
	 * @param isPrivate the isPrivate to set
	 */
	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	/**
	 * @return the comments
	 */
	@JsonProperty
	public Set<CommentDO> getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(Set<Comment> comments) {
		this.comments.clear();
		for(Comment c : comments){
			this.comments.add(new CommentDO(c));
		}
	}

	/**
	 * @return the tags
	 */
	@JsonProperty
	public Set<TagDO> getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(Set<Tag> tags) {
		this.tags.clear();
		for(Tag t : tags){
			this.tags.add(new TagDO(t));
		}
	}
}
