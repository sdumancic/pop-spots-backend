package clients;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

@Slf4j
public class UsersWiremockServerResource implements QuarkusTestResourceLifecycleManager {

    private final WireMockServer wireMockServer = new WireMockServer(wireMockConfig().dynamicPort());

    @Override
    public Map<String, String> start() {
        this.wireMockServer.start();
        var url = "http://localhost:%d".formatted(
                this.wireMockServer.isHttpsEnabled() ? this.wireMockServer.httpsPort() : this.wireMockServer.port()
        );
        log.info("xx {}", url);
        return Map.of(
                "quarkus.rest-client.users-api.url", url
        );
    }

    @Override
    public void stop() {
        this.wireMockServer.stop();
    }

    @Override
    public void inject(TestInjector testInjector) {
        testInjector.injectIntoFields(
                this.wireMockServer,
                new TestInjector.AnnotatedAndMatchesType(InjectWireMock.class, WireMockServer.class)
        );
        QuarkusTestResourceLifecycleManager.super.inject(testInjector);
    }
}
