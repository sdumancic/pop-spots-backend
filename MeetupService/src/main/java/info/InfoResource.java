package info;

import auth.Auth;
import auth.AuthService;
import clients.UsersRestClient;
import events.api.rest.dto.EventDto;
import events.api.rest.dto.EventFilterDto;
import events.service.TestService;
import info.nino.jpatron.annotiation.JsonApi;
import info.nino.jpatron.annotiation.JsonApiInject;
import info.nino.jpatron.jsonapi.request.JsonApiRequest;
import info.nino.jpatron.pagination.PageRequest;
import info.nino.jpatron.request.ApiRequest;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import user.api.rest.dto.UserDto;
import utils.Is404Exception;

import java.time.temporal.ChronoUnit;

@Path("/")
@RequestScoped
@Slf4j
@JsonApi
@NoArgsConstructor
public class InfoResource {

    @Inject
    AuthService authService;

    @Inject
    TestService testService;

    @JsonApiInject
    JsonApiRequest jsonApiRequest;

    ApiRequest apiRequest;

    @RestClient
    UsersRestClient usersRestClient;


    @GET
    @Auth
    @RolesAllowed("demo.read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response info() {
        authService.getRoles().forEach(log::info);
        return Response.ok().entity(authService.getClaimDto()).build();

    }

    @GET
    @Path("/api/users/userByObjectId")
    @Produces(MediaType.APPLICATION_JSON)
    @Retry(maxRetries = 3, delay = 200, delayUnit = ChronoUnit.MILLIS, abortOn = NotFoundException.class)
    public UserDto getUserByObjectId(@QueryParam("objectId") String objectId) {
        try {
            return usersRestClient.getByObjectId(objectId);
        } catch (WebApplicationException ex) {
            if (Is404Exception.IS_404.test(ex)) {
                throw new NotFoundException("User not found");
            }
            throw ex;
        }

    }

    @GET
    @Path("/paging")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonApi(value = EventDto.class, allowEntityPaths = true, allowedPaths = ".*")
    public Response testPaging(@BeanParam EventFilterDto eventFilterDto, @Context HttpHeaders httpHeaders) {
        PageRequest request = new PageRequest(this.jsonApiRequest);
        return Response.ok(testService.filter(request, eventFilterDto)).build();
    }


}
