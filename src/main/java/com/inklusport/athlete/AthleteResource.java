package com.inklusport.athlete;

import com.inklusport.athlete.dto.AthleteRequest;
import com.inklusport.athlete.dto.AthleteResponse;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/api/athletes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(
    name = "Athletes",
    description = "Operaciones para gestionar deportistas"
)
public class AthleteResource {

    @Inject
    AthleteService athleteService;

    @GET
    @Operation(
        summary = "Listar deportistas",
        description = "Obtiene todos los deportistas registrados"
    )
    public List<AthleteResponse> findAll() {
        return athleteService.findAll();
    }

    @GET
    @Path("/{id}")
    @Operation(
        summary = "Buscar deportista",
        description = "Obtiene los datos completos del deportista utilizando su identificador"
    )
    public Response findById(@PathParam("id") Long id) {

        return athleteService.findById(id)
                .map(Response::ok)
                .map(Response.ResponseBuilder::build)
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Operation(
        summary = "Crear deportista",
        description = "Registra los datos de un nuevo deportista"
    )
    public Response create(@Valid AthleteRequest request) {

        AthleteResponse created = athleteService.create(request);

        return Response.status(Response.Status.CREATED)
                .entity(created)
                .build();
    }

    @PUT
    @Path("/{id}")
    @Operation(
        summary = "Actualizar deportista",
        description = "Actualiza/Edita los datos de un deportista, buscado por su identificador"
    )
    public Response update(
            @PathParam("id") Long id,
            @Valid AthleteRequest request) {

        return athleteService.update(id, request)
                .map(Response::ok)
                .map(Response.ResponseBuilder::build)
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @DELETE
    @Path("/{id}")
    @Operation(
        summary = "Eliminar deportista",
        description = "Elimina los datos de un deportista ya registrado, buscado por su identificador"
    )
    public Response delete(@PathParam("id") Long id) {

        if (!athleteService.delete(id)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.noContent().build();
    }
}