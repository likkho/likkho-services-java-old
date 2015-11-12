/**
 *  Copyright (c) 2015 Likkho. All rights reserved.
 *
 */
package com.likkhoServices.displayObjects;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.likkhoServices.model.User;
import com.likkhoServices.model.UserLoginType;

public class UserDO extends DisplayObject implements DisplaybleObject {

	@Expose private String fullName;
	@Expose private String email;
	@Expose private UserLoginType loginType;
	@Expose private Date joiningDate;
	@Expose private String profilePicURL;
	@Expose private String tagline;
	
	public UserDO(User user){
		super.setId(user.getId());
		this.fullName = user.getFullName();
		this.email = user.getEmail();
		this.loginType = user.getLoginType();
		this.joiningDate = user.getJoiningDate();
		this.profilePicURL = user.getProfilePicURL();
		this.tagline = user.getTagline();
	}
	
	/**
	 * @return the fullName
	 */
	@JsonProperty
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
	@JsonProperty
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
	@JsonProperty
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
	@JsonProperty
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
	@JsonProperty
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
	@JsonProperty
	public String getTagline() {
		return tagline;
	}
	/**
	 * @param tagline the tagline to set
	 */
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}
}
