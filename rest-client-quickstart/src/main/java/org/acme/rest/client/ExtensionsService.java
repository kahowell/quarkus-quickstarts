package org.acme.rest.client;

import java.util.Set;
import java.util.concurrent.CompletionStage;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import io.smallrye.mutiny.Uni;

@Path("")
@RegisterRestClient
@RegisterClientHeaders(RequestUUIDHeaderFactory.class)
public interface ExtensionsService {

    @GET
    @Path("/{id}")
    Set<Extension> getById(@PathParam("id") String id);

    @GET
    CompletionStage<Set<Extension>> getByIdAsync(@QueryParam String id);

    @GET
    Uni<Set<Extension>> getByIdAsUni(@QueryParam String id);
}
