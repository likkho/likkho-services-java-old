/**
 *  Copyright (c) 2015 Likkho. All rights reserved.
 *
 */
package com.likkhoServices.model;

// Other Imports
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.google.gson.annotations.Expose;
import com.likkhoServices.displayObjects.DisplaybleObject;
import com.likkhoServices.displayObjects.UserDO;

// our imports


/**
 * @author mohkhan
 *
 */
@Entity
@Table(name = "ldb_users")
public class User extends LikkhoModel {
	
	@Expose private String fullName;
	@Expose private String email;
	@Expose private UserLoginType loginType;
	@Expose private Date joiningDate;
	@Expose private String profilePicURL;
	@Expose private String tagline;
	
	// Relationships
	private Set<User> followers;
	private Set<User> following;
	private Set<Community> followingCommunities;
	
	private Set<Post> savedPosts;
	
	public User() {
		super();
	}
	
	public User(String fullName, String email,
			UserLoginType loginType, Date joiningDate, String profilePicURL,
			String tagline) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.loginType = loginType;
		this.joiningDate = joiningDate;
		this.profilePicURL = profilePicURL;
		this.tagline = tagline;
	}
	
	/**
	 * @return the userId
	 */
	@Id
	@Column(name = "user_id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Override
	public int getId() {
		return this.id;
	}
	
	/**
	 * @return the fullName
	 */
	@Column(name = "user_full_name")
	public String getFullName() {
		return fullName;
	}
	
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	/**
	 * @return the email
	 */
	@Column(name = "user_email")
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the loginType
	 */
	@Column(name = "user_login_type")
	public UserLoginType getLoginType() {
		return loginType;
	}
	
	/**
	 * @param loginType the loginType to set
	 */
	public void setLoginType(UserLoginType loginType) {
		this.loginType = loginType;
	}
	
	/**
	 * @return the joiningDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "user_joining_date")
	public Date getJoiningDate() {
		return joiningDate;
	}
	
	/**
	 * @param joiningDate the joiningDate to set
	 */
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	/**
	 * @return the profilePicURL
	 */
	@Column(name = "user_profile_pic_url")
	public String getProfilePicURL() {
		return profilePicURL;
	}
	
	/**
	 * @param profilePicURL the profilePicURL to set
	 */
	public void setProfilePicURL(String profilePicURL) {
		this.profilePicURL = profilePicURL;
	}
	
	/**
	 * @return the tagline
	 */
	@Column(name = "user_tagline")
	public String getTagline() {
		return tagline;
	}
	
	/**
	 * @param tagline the tagline to set
	 */
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	@Override
	@Transient
	public DisplaybleObject getDisplayObject() {
		return new UserDO(this);
	}

	/**
	 * @return the followers
	 * /
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ldb_followers", joinColumns = { 
			@JoinColumn(name = "user_id") 
		}, 
		inverseJoinColumns = { @JoinColumn(name = "following_user_id") 
	})
	public Set<User> getFollowers() {
		return followers;
	}

	/**
	 * @param followers the followers to set
	 * /
	public void setFollowers(Set<User> followers) {
		this.followers = followers;
	}

	/**
	 * @return the following
	 * /
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ldb_followers", joinColumns = { 
			@JoinColumn(name = "user_id") 
		}, 
		inverseJoinColumns = { @JoinColumn(name = "user_id")
	})
	public Set<User> getFollowing() {
		return following;
	}

	/**
	 * @param following the following to set
	 * /
	public void setFollowing(Set<User> following) {
		this.following = following;
	}

	/**
	 * @return the followingCommunities
	 * /
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ldb_community_followers", joinColumns = { 
			@JoinColumn(name = "user_id") 
		}, 
		inverseJoinColumns = { @JoinColumn(name = "user_id") 
	})
	public Set<Community> getFollowingCommunities() {
		return followingCommunities;
	}

	/**
	 * @param followingCommunities the followingCommunities to set
	 * /
	public void setFollowingCommunities(Set<Community> followingCommunities) {
		this.followingCommunities = followingCommunities;
	}

	/**
	 * @return the savedPosts
	 * /
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ldb_saved_posts", joinColumns = { 
			@JoinColumn(name = "user_id") 
		}, 
		inverseJoinColumns = { @JoinColumn(name = "user_id")
	})
	public Set<Post> getSavedPosts() {
		return savedPosts;
	}

	/**
	 * @param savedPosts the savedPosts to set
	 * /
	public void setSavedPosts(Set<Post> savedPosts) {
		this.savedPosts = savedPosts;
	}
	*/
}
