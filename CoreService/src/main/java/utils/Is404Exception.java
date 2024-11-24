package utils;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

import java.util.Optional;
import java.util.function.Predicate;

public class Is404Exception implements Predicate<Throwable> {
    public static final Is404Exception IS_404 = new Is404Exception();

    private Is404Exception() {

    }

    @Override
    public boolean test(Throwable throwable) {
        return Optional.ofNullable(throwable)
                .filter(WebApplicationException.class::isInstance)
                .map(WebApplicationException.class::cast)
                .map(WebApplicationException::getResponse)
                .filter(response -> response.getStatus() == Response.Status.NOT_FOUND.getStatusCode())
                .isPresent();
    }
}