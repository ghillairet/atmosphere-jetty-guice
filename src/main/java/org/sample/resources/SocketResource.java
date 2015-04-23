package org.sample.resources;

import org.atmosphere.annotation.Broadcast;
import org.atmosphere.annotation.Suspend;
import org.sample.Service;
import org.sample.EventListener;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;

@Path("/")
@Singleton
@Produces("application/json")
public class SocketResource {

    private final Service service;

    @Inject
    public SocketResource(Service service) {
        this.service = service;
    }

    @GET
    @Suspend(listeners = EventListener.class)
    public String suspend() {
        return "";
    }

    @Broadcast(writeEntity = false)
    @POST
    public String broadcast(String message) {
        if (service == null) {
            throw new WebApplicationException(500);
        }
        return service.hello(message);
    }

}
