package user.api.rest;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import user.api.rest.dto.UserDto;
import user.service.UserService;

@RequestScoped
@Path("users")
public class UserResource {
    @Inject
    UserService userService;

    @GET
    @Path("/{objectId}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDto getUser(@PathParam("objectId") String objectId) {
        return userService.getUserByObjectId(objectId);
    }
}
