package clients;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Annotation that can be used to inject a {@link com.github.tomakehurst.wiremock.WireMockServer WireMockServer} into a test annotated with either {@link io.quarkus.test.junit.QuarkusTest @QuarkusTest} or {@link io.quarkus.test.junit.QuarkusIntegrationTest @QuarkusIntegrationTest}.
 * <p>
 * <pre>
 *     {@code
 * @InjectWireMock
 * WireMockServer server;
 *     }
 *   </pre>
 * </p>
 */
@Target({METHOD, CONSTRUCTOR, FIELD})
@Retention(RUNTIME)
@Documented
public @interface InjectWireMock {
}
