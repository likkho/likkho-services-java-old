/**
 *  Copyright (c) 2015 Likkho. All rights reserved.
 *
 */
package com.likkhoServices.resources;

import javax.json.Json;
import javax.json.JsonObject;

import com.likkhoServices.displayObjects.CommunityDO;
import com.likkhoServices.model.User;
import com.likkhoServices.service.CommunityService;
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

import com.likkhoServices.model.Community;

@Path("community")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Component("community")
@Scope("request")
public class CommunityResource extends BaseResource<CommunityDO> {
	
	private CommunityService communityService;
	
	@GET
    @Path("{id}")
    public JsonObject get(@PathParam("id") final long uId) {
        Community community = this.communityService.communityById(uId);
        CommunityDO dobj = (CommunityDO)community.getDisplayObject();
        String json = toJson(dobj);
        JsonObject jsonObject = Json.createObjectBuilder().add("Community", json).build();
        return jsonObject;
    }

	/**
	 * @return the communityService
	 */
	public CommunityService getCommunityService() {
		return communityService;
	}

	/**
	 * @param communityService the communityService to set
	 */
	@Autowired
	public void setCommunityService(CommunityService communityService) {
		this.communityService = communityService;
	}	
}

