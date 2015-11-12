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
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.google.gson.annotations.Expose;
import com.likkhoServices.displayObjects.DisplaybleObject;
import com.likkhoServices.displayObjects.PostDO;
import com.likkhoServices.displayObjects.TagDO;

@Entity
@Table(name = "ldb_posts")
public class Post extends LikkhoModel {
	
	private String title;
	private String text;
	private String mediaURL;
	private String postURL;
	private PostType type;
	private User author;
	private PostStatus status;
	private Community community;
	private String referenceURL;
	private Date createdOn;
	private int numMinutesToRead;
	private boolean isPrivate;
	
	// Relationships
	private Set<Tag> tags;
	private Set<Comment> comments;
	private Like like;
	private boolean markedOffensiveByUser;
	
	public Post() {
		super();
	}

	public Post(String title, String text, String mediaURL, String postURL,
			PostType type, User author, PostStatus status, Community community,
			String referenceURL,Date createdOn, int numMinutesToRead, boolean isPrivate) {
		super();
		this.title = title;
		this.text = text;
		this.mediaURL = mediaURL;
		this.postURL = postURL;
		this.type = type;
		this.author = author;
		this.status = status;
		this.community = community;
		this.referenceURL = referenceURL;
		this.createdOn = createdOn;
		this.numMinutesToRead = numMinutesToRead;
		this.isPrivate = isPrivate;
	}
	
	@Id
	@Column(name = "post_id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Override
	public int getId() {
		return this.id;
	}

	/**
	 * @return the title
	 */
	@Column(name = "post_title")
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
	@Column(name = "post_text")
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
	@Column(name = "post_media_url")
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
	@Column(name = "post_url")
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
	@Column(name = "post_type_id")
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
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "post_author_id")
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
	 * @return the status
	 */
	@Column(name = "post_status_id")
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
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "post_community_id", nullable = true)
	public Community getCommunity() {
		return community;
	}

	/**
	 * @param community the community to set
	 */
	public void setCommunity(Community community) {
		this.community = community;
	}

	/**
	 * @return the referenceURL
	 */
	@Column(name = "post_reference_url")
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
	 * @return the numMinutesToRead
	 */
	@Column(name = "num_min_read")
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
	@Column(name = "is_private")
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
	 * @return the createdOn
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "post_created_on")
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
	 * @return the tags
	 */
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "ldb_posts_tags", joinColumns = { 
			@JoinColumn(name = "post_id") 
		}, 
		inverseJoinColumns = { @JoinColumn(name = "tag_id") 
	})
	public Set<Tag> getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	@Override
	@Transient
	public DisplaybleObject getDisplayObject() {
		return new PostDO(this);
	}

	/**
	 * @return the comments
	 */
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="post")
	public Set<Comment> getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	/**
	 * @return the likedByUser
	 */
	@Transient
	public Like getLike() {
		return like;
	}

	/**
	 * @param likedByUser the likedByUser to set
	 */
	public void setLike(Like like) {
		this.like = like;
	}
}
