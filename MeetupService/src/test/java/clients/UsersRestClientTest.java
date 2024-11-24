package clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.quarkus.test.common.WithTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.faulttolerance.api.CircuitBreakerMaintenance;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import user.api.rest.dto.UserDto;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static jakarta.ws.rs.core.HttpHeaders.ACCEPT;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
@WithTestResource(UsersWiremockServerResource.class)
class UsersRestClientTest {

    private static final String USER_BY_OBJECT_ID_URL = "/users";

    private static final Integer DEFAULT_USER_ID = 1;
    private static final String DEFAULT_OBJECT_ID = "xxxxxx-11111111111-2222222222";
    private static final String DEFAULT_EMAIL = "emailxxx@test.com";
    private static final String DEFAULT_GENDER = "M";

    private static final UserDto DEFAULT_USER = UserDto.builder()
            .email(DEFAULT_EMAIL)
            .gender(DEFAULT_GENDER)
            .id(DEFAULT_USER_ID)
            .objectId(DEFAULT_OBJECT_ID)
            .build();

    //@Inject
    @RestClient
    UsersRestClient usersRestClient;

    @InjectWireMock
    WireMockServer wireMockServer;

    @Inject
    ObjectMapper objectMapper;

    @Inject
    CircuitBreakerMaintenance circuitBreakerMaintenance;

    @BeforeEach
    void beforeEach() {
        this.wireMockServer.resetAll();
    }

    @AfterEach
    void afterEach() {
        // Reset all circuit breaker counts after each test
        this.circuitBreakerMaintenance.resetAll();
    }

    @Test
    void findByObjectId() {
        WireMock.configureFor("localhost", this.wireMockServer.port());
        System.out.println("xxx " + WireMock.findAll(getRequestedFor(urlMatching("/users/.+"))));
        System.out.println("Requests received: " + WireMock.getAllServeEvents());
        this.wireMockServer.stubFor(
                get(urlPathMatching("/users/.+"))
                        .willReturn(okForContentType(APPLICATION_JSON, getDefaultUserJson()))
        );
        var user = this.usersRestClient.getByObjectId("12345");
        assertThat(user)
                .isNotNull().isEqualTo(DEFAULT_USER);
        this.wireMockServer.verify(1,
                getRequestedFor(urlEqualTo("/users/12345"))
                        .withHeader(ACCEPT, equalTo(APPLICATION_JSON)));
    }


    private String getDefaultUserJson() {
        try {
            return this.objectMapper.writeValueAsString(DEFAULT_USER);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }
}