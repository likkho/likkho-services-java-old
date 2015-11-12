/**
 *  Copyright (c) 2015 Likkho. All rights reserved.
 *
 */
package com.likkhoServices.displayObjects;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.likkhoServices.model.Comment;
import com.likkhoServices.model.User;

public class CommentDO extends DisplayObject implements DisplaybleObject {

	@Expose private int postId;
	@Expose private UserDO author;
	@Expose private String text;
	@Expose private Date commentedOn;
	
	public CommentDO(Comment comment){
		super.setId(comment.getId());
		this.postId = comment.getPost().getId();
		this.author = new UserDO(comment.getAuthor());
		this.text = comment.getText();
		this.commentedOn = comment.getCommentedOn();
	}
	
	/**
	 * @return the postId
	 */
	@JsonProperty
	protected int getPostId() {
		return postId;
	}
	/**
	 * @param postId the postId to set
	 */
	protected void setPostId(int postId) {
		this.postId = postId;
	}
	/**
	 * @return the author
	 */
	@JsonProperty
	protected UserDO getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	protected void setAuthor(UserDO author) {
		this.author = author;
	}
	/**
	 * @return the text
	 */
	@JsonProperty
	protected String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	protected void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the commentedOn
	 */
	@JsonProperty
	protected Date getCommentedOn() {
		return commentedOn;
	}
	/**
	 * @param commentedOn the commentedOn to set
	 */
	protected void setCommentedOn(Date commentedOn) {
		this.commentedOn = commentedOn;
	}
}
