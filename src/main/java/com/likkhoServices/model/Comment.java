/**
 *  Copyright (c) 2015 Likkho. All rights reserved.
 *
 */
package com.likkhoServices.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.google.gson.annotations.Expose;
import com.likkhoServices.displayObjects.CommentDO;
import com.likkhoServices.displayObjects.DisplaybleObject;

@Entity
@Table(name = "ldb_comments")
public class Comment extends LikkhoModel {
	
	@Expose private int postId;
	@Expose private User author;
	@Expose private String text;
	@Expose private Date commentedOn;
	
	Post post;
	
	// Relationships
	Set<Comment> replies;

	public Comment() {
		super();
	}

	public Comment(int postId, User author, String text, Date commentedOn) {
		super();
		this.postId = postId;
		this.author = author;
		this.text = text;
		this.commentedOn = commentedOn;
	}
	
	@Id
	@Column(name = "comment_id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Override
	public int getId() {
		return this.id;
	}
	

	/**
	 * @return the author
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "comment_author_id")
	public User getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(User author) {
		this.author = author;
	}

	/**
	 * @return the text
	 */
	@Column(name = "comment_text")
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
	 * @return the commentedOn
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "commentd_on")
	public Date getCommentedOn() {
		return commentedOn;
	}

	/**
	 * @param commentedOn the commentedOn to set
	 */
	public void setCommentedOn(Date commentedOn) {
		this.commentedOn = commentedOn;
	}

	/**
	 * @return the replies
	 */
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "reply_to_comment_id")
	public Set<Comment> getReplies() {
		return replies;
	}

	/**
	 * @param replies the replies to set
	 */
	public void setReplies(Set<Comment> replies) {
		this.replies = replies;
	}

	@Override
	@Transient
	public DisplaybleObject getDisplayObject() {
		return new CommentDO(this);
	}

	/**
	 * @return the post
	 */
	@ManyToOne
    @JoinColumn(name="post_id")
	public Post getPost() {
		return post;
	}

	/**
	 * @param post the post to set
	 */
	public void setPost(Post post) {
		this.post = post;
	}
}
