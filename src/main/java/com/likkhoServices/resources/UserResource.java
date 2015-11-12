/**
 *  Copyright (c) 2015 Likkho. All rights reserved.
 *
 */
package com.likkhoServices.resources;

import javax.json.Json;
import javax.json.JsonObject;

import com.likkhoServices.displayObjects.UserDO;
import com.likkhoServices.model.User;
import com.likkhoServices.service.UserService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Path("user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Component("user")
@Scope("request")
public class UserResource extends BaseResource<UserDO>{
	
	private UserService userService;
	
	@GET
    @Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public UserDO get(@PathParam("id") final long uId) {
        User user = this.userService.userById(uId);
        UserDO dobj = (UserDO)user.getDisplayObject();
        return dobj;
    }

	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @param userService the userService to set
	 */
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
