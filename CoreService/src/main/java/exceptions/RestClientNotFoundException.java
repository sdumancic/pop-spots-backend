package exceptions;

import jakarta.ws.rs.WebApplicationException;

public class RestClientNotFoundException extends WebApplicationException {
    public RestClientNotFoundException(String message) {
        super(message);
    }

    public RestClientNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
