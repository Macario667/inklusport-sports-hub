package com.inklusport.external;

import com.inklusport.external.dto.ExternalPostResponse;
import com.inklusport.external.service.ExternalPostService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/external/posts")
@Produces(MediaType.APPLICATION_JSON)
public class ExternalPostResource {
    
    @Inject
    ExternalPostService service;

    @GET 
    @Path("/{id}")
    public ExternalPostResponse getPost(@PathParam("id") Long id) {
        return service.getPost(id);
    }
}
