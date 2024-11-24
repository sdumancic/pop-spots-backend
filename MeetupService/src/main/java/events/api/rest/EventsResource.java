package events.api.rest;

import auth.Auth;
import auth.AuthService;
import events.service.EventService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import user.api.rest.dto.UserDto;
import user.service.UserService;

@RequestScoped
@Path("/events")
@Slf4j
public class EventsResource {

    @Inject
    AuthService authService;

    @Inject
    EventService eventService;

    @Inject
    UserService userService;


    @GET
    @Path("/{eventId}")
    @Auth
    //@RolesAllowed("events.read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEvent(@PathParam("eventId") Long eventId) {
        String objectId = authService.getSubject();
        UserDto userDto = userService.getUserByObjectId(objectId);
        return Response.ok().entity(eventService.getById(eventId, userDto.getId())).build();

    }
}
