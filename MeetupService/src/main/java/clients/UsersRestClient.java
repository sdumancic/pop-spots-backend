package clients;

import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import io.smallrye.faulttolerance.api.CircuitBreakerName;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import user.api.rest.dto.UserDto;

import java.time.temporal.ChronoUnit;

@Path("/users")
@RegisterRestClient(configKey = "users-api")
@RegisterClientHeaders(AuthHeaderFactory.class)
public interface UsersRestClient {

    @GET
    @Path("/{objectId}")
    @CircuitBreaker(requestVolumeThreshold = 8, failureRatio = 0.5, delay = 2, delayUnit = ChronoUnit.SECONDS)
    @CircuitBreakerName("getByObjectId")
    @WithSpan(kind = SpanKind.CLIENT, value = "UsersRestClient.getByObjectId")
    @Produces(MediaType.APPLICATION_JSON)
    UserDto getByObjectId(@PathParam("objectId") String objectId);

}
