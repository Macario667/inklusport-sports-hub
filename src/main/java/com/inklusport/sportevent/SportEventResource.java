package com.inklusport.sportevent;

import java.util.List;

import com.inklusport.sportevent.dto.SportEventRequest;
import com.inklusport.sportevent.dto.SportEventResponse;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*; /** Métodos HTTP */
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/api/events")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(
    name = "Sport Events",
    description = "Operaciones para gestionar eventos deportivos"
)
public class SportEventResource {

    @Inject
    SportEventService eventService;

    @GET
    @Operation(summary = "Listar eventos deportivos")
    public List<SportEventResponse> findAll() {
        return eventService.findAll();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Consultar evento deportivo")
    public Response findById(@PathParam("id") String id) {
        return eventService.findById(id)
                .map(Response::ok)
                .map(Response.ResponseBuilder::build)
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Operation(summary = "Crear evento deportivo")
    public Response create(@Valid SportEventRequest request) {
        SportEventResponse created = eventService.create(request);

        return Response.status(Response.Status.CREATED)
                .entity(created)
                .build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Actualizar evento deportivo")
    public Response update(
            @PathParam("id") String id,
            @Valid SportEventRequest request) {

        return eventService.update(id, request)
                .map(Response::ok)
                .map(Response.ResponseBuilder::build)
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Eliminar evento deportivo")
    public Response delete(@PathParam("id") String id) {
        if (!eventService.delete(id)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.noContent().build();
    }
}