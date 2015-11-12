/**
 *  Copyright (c) 2015 Likkho. All rights reserved.
 *
 */
package com.likkhoServices.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.google.gson.annotations.Expose;
import com.likkhoServices.displayObjects.DisplaybleObject;
import com.likkhoServices.displayObjects.TagDO;

@Entity
@Table(name = "ldb_tags")
public class Tag extends LikkhoModel {
	
	@Expose private String name;
	@Expose private long rank;
	
	// Relationships
	private Set<Post> posts;
	
	public Tag() {
		super();
	}

	public Tag(String name, long rank) {
		super();
		this.name = name;
		this.rank = rank;
	}
	
	@Id
	@Column(name = "tag_id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Override
	public int getId() {
		return this.id;
	}

	/**
	 * @return the name
	 */
	@Column(name = "tag_name")
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
	 * @return the rank
	 */
	@Column(name = "tag_rank")
	public long getRank() {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(long rank) {
		this.rank = rank;
	}

	/**
	 * @return the posts
	 */
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
	public Set<Post> getPosts() {
		return posts;
	}

	/**
	 * @param posts the posts to set
	 */
	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	@Override
	@Transient
	public DisplaybleObject getDisplayObject() {
		return new TagDO(this);
	}
}
