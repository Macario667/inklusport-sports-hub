package com.inklusport.external.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.inklusport.external.dto.ExternalPostResponse;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/posts")
@RegisterRestClient(configKey = "posts-api")
@Produces(MediaType.APPLICATION_JSON)
public interface  ExternalPostClient {
    
    @GET
    @Path("/{id}")
    ExternalPostResponse getPost(@PathParam("id") Long id);
}
