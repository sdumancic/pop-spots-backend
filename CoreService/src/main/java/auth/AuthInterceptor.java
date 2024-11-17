package auth;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;

@Auth
@Interceptor
@Priority(1)
public class AuthInterceptor {

    @Inject
    @Context
    SecurityIdentity securityIdentity;

    @AroundInvoke
    public Object enforceAuth(InvocationContext context) throws Exception {
        if (securityIdentity.isAnonymous()) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Please log in")
                    .build();
        }

        return context.proceed();
    }
}
