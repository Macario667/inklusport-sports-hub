package com.inklusport.athlete;

import com.inklusport.athlete.dto.AthleteRequest;
import com.inklusport.athlete.dto.AthleteResponse;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/athletes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AthleteResource {

    @Inject
    AthleteService athleteService;

    @GET
    public List<AthleteResponse> findAll() {
        return athleteService.findAll();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {

        return athleteService.findById(id)
                .map(Response::ok)
                .map(Response.ResponseBuilder::build)
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    public Response create(AthleteRequest request) {

        AthleteResponse created = athleteService.create(request);

        return Response.status(Response.Status.CREATED)
                .entity(created)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response update(
            @PathParam("id") Long id,
            AthleteRequest request) {

        return athleteService.update(id, request)
                .map(Response::ok)
                .map(Response.ResponseBuilder::build)
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {

        if (!athleteService.delete(id)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.noContent().build();
    }
}