package events.api.rest;

import auth.Auth;
import auth.AuthService;
import events.api.rest.dto.CreateEventDto;
import events.api.rest.dto.EventDto;
import events.service.EventService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import user.api.rest.dto.UserDto;
import user.service.UserService;

import java.net.URI;

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

    @POST
    //@Auth
    //@RolesAllowed("events.read")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createEvent(CreateEventDto dto) {
        log.info("CREATE event {}", dto);
        String objectId = authService.getSubject();
        UserDto userDto = userService.getUserByObjectId(objectId);
        EventDto createdEvent = eventService.createEvent(dto, userDto);
        URI location = URI.create("/events/" + createdEvent.getId());
        return Response.seeOther(location).build();
    }
}
