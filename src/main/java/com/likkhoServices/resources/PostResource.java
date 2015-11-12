/**
 *  Copyright (c) 2015 Likkho. All rights reserved.
 *
 */
package com.likkhoServices.resources;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.likkhoServices.displayObjects.PostDO;
import com.likkhoServices.model.Post;
import com.likkhoServices.service.PostService;

@Path("post")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Component("post")
@Scope("request")
public class PostResource extends BaseResource<PostDO>{
	
	private PostService postService;
	
	@GET
    @Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public PostDO get(@PathParam("id") final long uId) {
        Post post = this.postService.postById(uId);
        PostDO dobj = (PostDO)post.getDisplayObject();
        return dobj;
    }
	
	@GET
    @Path("{id}/detail")
	@Produces(MediaType.APPLICATION_JSON)
    public PostDO getPostWithComments(@PathParam("id") final long uId) {
        Post post = this.postService.postById(uId);
        PostDO dobj = (PostDO)post.getDisplayObject();
        dobj.setComments(post.getComments());
        dobj.setTags(post.getTags());
        return dobj;
    }

	/**
	 * @return the postService
	 */
	public PostService getPostService() {
		return postService;
	}

	/**
	 * @param postService the postService to set
	 */
	@Autowired
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
}
