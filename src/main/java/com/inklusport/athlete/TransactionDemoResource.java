package com.inklusport.athlete;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/api/transactions")
public class TransactionDemoResource {

    @Inject
    TransactionDemoService transactionDemoService;

    @POST
    @Path("/rollback")
    public Response testRollback() {

        transactionDemoService.createAthleteAndFail();

        return Response.ok("Transaction completed").build();
    }
}